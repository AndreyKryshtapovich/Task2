package by.epamtc.task2.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import by.epamtc.task2.entity.Dish;
import by.epamtc.task2.entity.Menu;
import by.epamtc.task2.parser.helper.StringConstants;

public class DomHelper {
	private DomHelper(){}
	
	public static Menu domParse(Document document){
		Menu menu = new Menu();
		Element root = document.getDocumentElement();
		
		Element coldDishElement = (Element) root.getElementsByTagName(StringConstants.qNameColdDishes).item(0);
		Element hotDishElement = (Element) root.getElementsByTagName(StringConstants.qNameHotDishes).item(0);
		Element breakfastElement = (Element) root.getElementsByTagName(StringConstants.qNameBreakfasts).item(0);
		
		NodeList colDishList = coldDishElement.getElementsByTagName(StringConstants.qNameDishStr);
		NodeList hotDishList = hotDishElement.getElementsByTagName(StringConstants.qNameDishStr);
		NodeList breakfastList = breakfastElement.getElementsByTagName(StringConstants.qNameDishStr);
		
		menu.setColdDishList(listParse(colDishList));
		menu.setHotDishList(listParse(hotDishList));
		menu.setBreakfastList(listParse(breakfastList));
		
		return menu;
	}
	
	public static List<Dish> listParse(NodeList currentList){
		List<Dish> list = new ArrayList<>();
		for(int i = 0; i < currentList.getLength();i++){
			Dish dish = new Dish();
			Element dishElement = (Element) currentList.item(i);
			dish.setId(dishElement.getAttribute(StringConstants.id));
			dish.setPhoto(getSingleChild(dishElement,StringConstants.qNamePhoto).getTextContent().trim());
			dish.setName(getSingleChild(dishElement,StringConstants.qName).getTextContent().trim());
			dish.setDescription(getSingleChild(dishElement,StringConstants.qNameDescription).getTextContent().trim());
			dish.setPortion(getSingleChild(dishElement,StringConstants.qNamePortion).getTextContent().trim());
			dish.setPrice(Integer.parseInt(getSingleChild(dishElement,StringConstants.qNamePrice).getTextContent().trim()));
			list.add(dish);
		}
		return list;
	}
	
	private static Element getSingleChild(Element element, String childName){
	    NodeList nlist = element.getElementsByTagName(childName);
	    Element child = (Element) nlist.item(0);
	    return child;
	}

}
