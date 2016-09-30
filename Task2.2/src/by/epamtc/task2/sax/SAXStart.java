package by.epamtc.task2.sax;

import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.epamtc.task2.entity.Menu;
import by.epamtc.task2.view.View;

public class SAXStart {

	public static void main(String[] args) {
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			MenuSaxHandler handler = new MenuSaxHandler();
			reader.setContentHandler(handler);
			reader.parse(new InputSource("src/res/Menu.xml"));
			Menu menu = handler.getMenu();
			View.displayMenu(menu);
		} catch (SAXException e) {
			System.out.println("Sorry something went wrong. Please chech your XML file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Sorry something went wrong. Please chech the location of your XML file");
			e.printStackTrace();
		}
		

	}

}
