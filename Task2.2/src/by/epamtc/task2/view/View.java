package by.epamtc.task2.view;

import by.epamtc.task2.entity.Dish;
import by.epamtc.task2.entity.Menu;

public class View {
	public static void displayMenu(Menu menu){
		System.out.println("Cold dishes");
		System.out.println();
		for(Dish dish: menu.getColdDishList()){
			System.out.println(dish.toString());
		}
		System.out.println("Hot dishes");
		System.out.println();
		for(Dish dish: menu.getHotDishList()){
			System.out.println(dish.toString());
		}
		System.out.println("Breakfasts");
		System.out.println();
		for(Dish dish: menu.getBreakfastList()){
			System.out.println(dish.toString());
		}
}
}