package by.epamtc.task2.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epamtc.task2.entity.Menu;
import by.epamtc.task2.view.View;

public class StaxStart {

	public static void main(String[] args) {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		
		try {
			InputStream input = new FileInputStream("src/res/Menu.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			Menu menu = StaxHelper.process(reader);
			View.displayMenu(menu);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		

	}
	
	
	

}
