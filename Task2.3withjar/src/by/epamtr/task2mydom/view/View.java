package by.epamtr.task2mydom.view;

import by.epamtr.task2mydom.entity.Dish;
import by.epamtr.task2mydom.entity.Menu;
import by.epamtr.task2mydom.parser.helper.StringConstants;

public class View {
	public static void displayMenu(Menu menu){
		System.out.println(StringConstants.coldDishes);
		System.out.println();
		for(Dish dish: menu.getColdDishList()){
			System.out.println(dish.toString());
		}
		System.out.println(StringConstants.hotDishes);
		System.out.println();
		for(Dish dish: menu.getHotDishList()){
			System.out.println(dish.toString());
		}
		System.out.println(StringConstants.breakfasts);
		System.out.println();
		for(Dish dish: menu.getBreakfastList()){
			System.out.println(dish.toString());
		}
	}
}
