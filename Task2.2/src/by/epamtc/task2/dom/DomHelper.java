package by.epamtc.task2.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import by.epamtc.task2.entity.Dish;
import by.epamtc.task2.entity.Menu;

public class DomHelper {
	private DomHelper(){}
	
	public static Menu domParse(Document document){
		Menu menu = new Menu();
		Element root = document.getDocumentElement();
		
		Element coldDishElement = (Element) root.getElementsByTagName("cd:cold-dishes").item(0);
		Element hotDishElement = (Element) root.getElementsByTagName("cd:hot-dishes").item(0);
		Element breakfastElement = (Element) root.getElementsByTagName("cd:breakfasts").item(0);
		
		NodeList colDishList = coldDishElement.getElementsByTagName("cd:dish");
		NodeList hotDishList = hotDishElement.getElementsByTagName("cd:dish");
		NodeList breakfastList = breakfastElement.getElementsByTagName("cd:dish");
		
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
			dish.setId(dishElement.getAttribute("id"));
			dish.setPhoto(getSingleChild(dishElement,"cd:photo").getTextContent().trim());
			dish.setName(getSingleChild(dishElement,"cd:name").getTextContent().trim());
			dish.setDescription(getSingleChild(dishElement,"cd:description").getTextContent().trim());
			dish.setPortion(getSingleChild(dishElement,"cd:portion").getTextContent().trim());
			dish.setPrice(Integer.parseInt(getSingleChild(dishElement,"cd:price").getTextContent().trim()));
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
