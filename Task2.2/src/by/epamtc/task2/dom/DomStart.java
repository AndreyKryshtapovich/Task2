package by.epamtc.task2.dom;

import java.io.IOException;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import by.epamtc.task2.entity.Menu;
import by.epamtc.task2.parser.helper.StringConstants;
import by.epamtc.task2.view.View;

public class DomStart {

	public static void main(String[] args) {
		try {
			DOMParser parser = new DOMParser();
			parser.parse(new InputSource(StringConstants.resources));
			Document document = parser.getDocument();
			Menu menu = DomHelper.domParse(document);
			View.displayMenu(menu);
			
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
