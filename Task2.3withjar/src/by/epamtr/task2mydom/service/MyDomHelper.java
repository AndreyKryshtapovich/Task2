package by.epamtr.task2mydom.service;

import java.util.ArrayList;
import java.util.List;

import by.epamtc.task2domparser.entity.Document;
import by.epamtc.task2domparser.entity.Element;
import by.epamtr.task2mydom.entity.Dish;
import by.epamtr.task2mydom.entity.Menu;


public class MyDomHelper {
	
	private MyDomHelper(){}
	
	public static Menu domParse(Document document){
		Menu menu = new Menu();
		Element root = document.getTree();
		
		Element coldDishElement = (Element) root.getElementsByName("cd:cold-dishes").get(0);
		Element hotDishElement = (Element) root.getElementsByName("cd:hot-dishes").get(0);
		Element breakfastElement = (Element) root.getElementsByName("cd:breakfasts").get(0);
		
		List<Element> colDishList = coldDishElement.getElementsByName("cd:dish");
		List<Element> hotDishList = hotDishElement.getElementsByName("cd:dish");
		List<Element> breakfastList = breakfastElement.getElementsByName("cd:dish");
		
		menu.setColdDishList(listParse(colDishList));
		menu.setHotDishList(listParse(hotDishList));
		menu.setBreakfastList(listParse(breakfastList));
		
		return menu;
	}
	
	public static List<Dish> listParse(List<Element> currentList){
		List<Dish> list = new ArrayList<>();
		for(int i = 0; i < currentList.size();i++){
			Dish dish = new Dish();
			Element dishElement = (Element) currentList.get(i);
			dish.setId(dishElement.getAttributes().get(0).getValue());
			dish.setPhoto(getSingleChild(dishElement,"cd:photo").getText().getTextContent());
			dish.setName(getSingleChild(dishElement,"cd:name").getText().getTextContent());
			dish.setDescription(getSingleChild(dishElement,"cd:description").getText().getTextContent());
			dish.setPortion(getSingleChild(dishElement,"cd:portion").getText().getTextContent());
			dish.setPrice(Integer.parseInt(getSingleChild(dishElement,"cd:price").getText().getTextContent()));
			list.add(dish);
		}
		return list;
	}
	
	private static Element getSingleChild(Element element, String childName){
	    List<Element> nlist = element.getElementsByName(childName);
	    Element child = (Element) nlist.get(0);
	    return child;
	}
}
