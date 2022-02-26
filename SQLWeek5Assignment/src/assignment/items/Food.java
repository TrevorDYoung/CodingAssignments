package assignment.items;

import java.util.ArrayList;
import java.util.List;

public class Food {
	private String name;
	
	//Note: Since this contains list of, It is immutable, thus, unsortable.
	private static List <Food> foods =List.of
		(new Food("banana"), new Food("pie"), new Food("apples"), new Food("rocks"));
	
	
	public Food (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return name + " " + "Food";
	}
	
	public static int compare (Food b1, Food b2) {
		return b1.getName().compareTo(b2.getName());
	}
	
	public static List<Food> getFoods() {
		//Create a new ArrayList using the constructor that takes a collection as a parameter.
		return new ArrayList<>(foods);
	}
}

