package by.epamtc.task2domparser.start;

import by.epamtc.task2domparser.service.impl.BaseDomParser;
import by.epamtc.task2domparser.service.impl.DomFactory;


public class Main {

	public static void main(String[] args) {
		
		DomFactory factory = DomFactory.getInstance();
		BaseDomParser parser = (BaseDomParser) factory.create();
		parser.parse("src/res/Menu.xml");
	}
}