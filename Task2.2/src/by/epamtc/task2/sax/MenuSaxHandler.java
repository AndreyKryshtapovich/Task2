package by.epamtc.task2.sax;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epamtc.task2.entity.Dish;
import by.epamtc.task2.entity.Menu;
import by.epamtc.task2.entity.MenuTagName;
import by.epamtc.task2.parser.helper.StringConstants;

public class MenuSaxHandler extends DefaultHandler {
	private Menu menu = new Menu();
	private Dish dish;
	private List<Dish> currentList;
	private StringBuilder text;
	
	
	
	public Menu getMenu() {
		return menu;
	}
	
	public void startDocument() throws SAXException {
		System.out.println("Parsing started.");
	}

	public void endDocument() throws SAXException {
		System.out.println("Parsing ended.");
	}
	
	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		text = new StringBuilder();
		
		if (localName.equals(StringConstants.coldDishes)) {
			currentList = menu.getColdDishList();
		}else{
			if(localName.equals(StringConstants.hotDishes)){
				currentList = menu.getHotDishList();
			}else{
				if(localName.equals(StringConstants.breakfasts)){
					currentList = menu.getBreakfastList();
				}
			}
		}
		
		if (localName.equals(StringConstants.dishStr)) {
			dish = new Dish();
			dish.setId(attributes.getValue(StringConstants.id));
		}
		
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		MenuTagName tagName = MenuTagName.valueOf(localName.toUpperCase().replace("-", "_"));

		switch (tagName) {
		case NAME:
			dish.setName(text.toString());
			break;
		case PRICE:
			dish.setPrice(Integer.parseInt(text.toString()));
			break;
		case DESCRIPTION:
			dish.setDescription(text.toString());
			break;
		case PHOTO:
			dish.setPhoto(text.toString());
			break;
		case PORTION:
			dish.setPortion(text.toString());
			break;
		case DISH:
			currentList.add(dish);
			dish = null;
			break;
			default : break;
		}
	}

}
