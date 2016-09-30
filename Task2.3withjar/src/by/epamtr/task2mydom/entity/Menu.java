package by.epamtr.task2mydom.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<Dish> coldDishList = new ArrayList<Dish>();
	private List<Dish> hotDishList = new ArrayList<Dish>();
	private List<Dish> breakfastList = new ArrayList<Dish>();
	
	@Override
	public String toString() {
		return "Menu [coldDishList=" + coldDishList + ", hotDishList=" + hotDishList + ", breakfastList="
				+ breakfastList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((breakfastList == null) ? 0 : breakfastList.hashCode());
		result = prime * result + ((coldDishList == null) ? 0 : coldDishList.hashCode());
		result = prime * result + ((hotDishList == null) ? 0 : hotDishList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (breakfastList == null) {
			if (other.breakfastList != null)
				return false;
		} else if (!breakfastList.equals(other.breakfastList))
			return false;
		if (coldDishList == null) {
			if (other.coldDishList != null)
				return false;
		} else if (!coldDishList.equals(other.coldDishList))
			return false;
		if (hotDishList == null) {
			if (other.hotDishList != null)
				return false;
		} else if (!hotDishList.equals(other.hotDishList))
			return false;
		return true;
	}

	public List<Dish> getColdDishList() {
		return coldDishList;
	}

	public void setColdDishList(List<Dish> coldDishList) {
		this.coldDishList = coldDishList;
	}

	public List<Dish> getHotDishList() {
		return hotDishList;
	}

	public void setHotDishList(List<Dish> hotDishList) {
		this.hotDishList = hotDishList;
	}

	public List<Dish> getBreakfastList() {
		return breakfastList;
	}

	public void setBreakfastList(List<Dish> breakfastList) {
		this.breakfastList = breakfastList;
	}
	



}
