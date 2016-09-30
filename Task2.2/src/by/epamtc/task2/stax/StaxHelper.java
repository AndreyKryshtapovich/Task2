package by.epamtc.task2.stax;

import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epamtc.task2.entity.Dish;
import by.epamtc.task2.entity.Menu;
import by.epamtc.task2.entity.MenuTagName;

public class StaxHelper {
	public static Menu process(XMLStreamReader reader) throws XMLStreamException {
		Menu menu = new Menu();
		Dish dish = null;
		MenuTagName elementName = null;
		List<Dish> currentList = null;

		while (reader.hasNext()) {

			int type = reader.next();

			switch (type) {
			
			case XMLStreamConstants.START_ELEMENT:
				elementName =  MenuTagName.valueOf(reader.getLocalName().toUpperCase().replace("-", "_"));
				dish =  startElement(elementName,reader,currentList,menu,dish);
				currentList = setCurrentList(elementName,currentList,menu);
				break;
				
			case XMLStreamConstants.CHARACTERS:
				addText(elementName,reader, dish);
				break;
				
			case XMLStreamConstants.END_ELEMENT:
				elementName =  MenuTagName.valueOf(reader.getLocalName().toUpperCase().replace("-", "_"));
				endElement(elementName,currentList,dish);
			}
		}
		return menu;
	}
	
	
	private static Dish startElement(MenuTagName elementName,XMLStreamReader reader,List<Dish> currentList,Menu menu,Dish dish){

		if (elementName == MenuTagName.DISH) {
			dish = new Dish();
			dish.setId(reader.getAttributeValue(null, "id"));
		}
		return dish;
	}
	private static List<Dish> setCurrentList(MenuTagName elementName,List<Dish> currentList, Menu menu){
		if (elementName == MenuTagName.COLD_DISHES) {
			currentList = menu.getColdDishList();
		} else {
			if (elementName == MenuTagName.HOT_DISHES) {
				currentList = menu.getHotDishList();
			} else {
				if (elementName == MenuTagName.BREAKFASTS) {
					currentList = menu.getBreakfastList();
				}
			}
		}
		return currentList;

	}
	
	private static void addText(MenuTagName elementName, XMLStreamReader reader, Dish dish){
		String text = reader.getText().trim();
		if (text.isEmpty()) {
			return;
		}
		switch (elementName) {
		case NAME:
			dish.setName(text);
			break;
		case PRICE:
			dish.setPrice(Integer.parseInt(text));
			break;
		case DESCRIPTION:
			dish.setDescription(text);
			break;
		case PHOTO:
			dish.setPhoto(text);
			break;
		case PORTION:
			dish.setPortion(text);
		}
	}
	
	private static void endElement(MenuTagName elementName,List<Dish> currentList, Dish dish){
		switch (elementName) {
		case DISH:
			currentList.add(dish);
			dish = null;
			break;
		default : 
			break;
		}
	}
}
