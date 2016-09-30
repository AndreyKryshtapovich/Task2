package by.epamtc.task2domparser.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PushbackReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epamtc.task2domparser.entity.Attribute;
import by.epamtc.task2domparser.entity.Document;
import by.epamtc.task2domparser.entity.Element;
import by.epamtc.task2domparser.entity.Text;
import by.epamtc.task2domparser.service.DomParser;

public class BaseDomParser implements DomParser {
	private static final String regexStartEnd = "(<((/?)([\\w:\\-]+)((([ \\s]+)([\\w:\\-]+)=(\"[\\.\\w\\-:/ ]+\"))*))>)|"
			+ "([/à-ÿÀ-ß\\., :\\w\\-&&[^<>]]+<)";
	private static final String charset = "UTF-8";
	private static final String slash = "/";
	private static final String beginTag = "<";

	public Document parse(String fileName) {
		PushbackReader pb = null;
		List<Element> stackOfElements = new ArrayList<>();
		Document document = new Document();

		try {
			Path path = Paths.get(fileName);
			BufferedReader br = Files.newBufferedReader(path, Charset.forName(charset));
			pb = new PushbackReader(br);

			Pattern startEnd = Pattern.compile(regexStartEnd);
			Matcher matcher;
			String s = "";

			while (pb.ready()) {

				char c = (char) pb.read();
				s = s + c;
				matcher = startEnd.matcher(s);

				if (matcher.find()) {
					if (matcher.group(1) != null) {
						startElement(stackOfElements, matcher);
					}

					s = "";
					if (matcher.group(5) != null) {
						addAttributes(stackOfElements, matcher);
					}
					if (matcher.group(10) != null) {
						s = beginTag;
						addText(stackOfElements, matcher);
					}
				}

			}
			createTree(stackOfElements, document);
			//System.out.println(document.getTree().getChilds().size());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return document;
	}

	private static void startElement(List<Element> stackOfElements, Matcher matcher) {
		Element element = new Element();
		if (matcher.group(1).contains(slash)) {
			element.setTagName(slash + matcher.group(4));
		} else {
			element.setTagName(matcher.group(4));
		}
		stackOfElements.add(element);
	}

	private static void addAttributes(List<Element> stackOfElements, Matcher matcher) {
		String name = matcher.group(8); 
		String value = matcher.group(9);
		Attribute attr = new Attribute();
		attr.setName(name);
		attr.setValue(value);
		stackOfElements.get(stackOfElements.size() - 1).getAttributes().add(attr);
	}

	private static void addText(List<Element> stackOfElements, Matcher matcher) {
		Text text = new Text();
		text.setTextContent(matcher.group(10).substring(0, matcher.group(10).indexOf(beginTag)));
		stackOfElements.get(stackOfElements.size() - 1).setText(text);

	}

	private static void createTree(List<Element> stackOfElements, Document document) {
		List<Element> stack2 = new ArrayList<>();
		stackOfElements.get(0).setTagName(stackOfElements.get(0).getTagName().substring(1));
		stack2.add(stackOfElements.get(0));
		document.setTree((stack2.get(0)));
		int i2 = 0;
		for (int i = 0; i < stackOfElements.size() - 1; i++) {
			if (!(stackOfElements.get(i + 1).getTagName().equals(slash + stack2.get(i2).getTagName()))) {
				stack2.add(stackOfElements.get(i + 1));
				stack2.get(i2).getChilds().add(stackOfElements.get(i + 1));
				i2 = i2 + 1;
			} else {
				stack2.remove(i2);
				i2--;
			}
		}
	}
}
