package by.epamtr.task2mydom.start;

import by.epamtc.task2domparser.entity.Document;
import by.epamtc.task2domparser.service.impl.BaseDomParser;
import by.epamtc.task2domparser.service.impl.DomFactory;
import by.epamtr.task2mydom.entity.Menu;
import by.epamtr.task2mydom.parser.helper.StringConstants;
import by.epamtr.task2mydom.service.MyDomHelper;
import by.epamtr.task2mydom.view.View;

public class MyDomStart {

	public static void main(String[] args) {
		
			Menu menu = new Menu();
			DomFactory factory = DomFactory.getInstance();
			BaseDomParser parser = (BaseDomParser) factory.create();
			Document document =  (Document) parser.parse(StringConstants.resources);
			menu = MyDomHelper.domParse(document);
			View.displayMenu(menu);
	}
	
}
