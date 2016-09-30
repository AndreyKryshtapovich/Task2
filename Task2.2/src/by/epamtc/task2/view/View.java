package by.epamtc.task2.view;

import by.epamtc.task2.entity.Dish;
import by.epamtc.task2.entity.Menu;
import by.epamtc.task2.parser.helper.StringConstants;

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