package assignment.app;

import java.util.List;

import assignment.items.Food;

public class MainMethod {

	public static void main(String[] args) {
		
	sortLamb();
	sortByMethR();
	
	}
	private static void sortLamb() {
		//This creates a List with the method in Food class.
		List <Food> foodLamb = Food.getFoods();
		//To my understanding, line 22 takes 2 Food at a time and compares them
		//with my method. Next ".sort" will increment up ONE. 
		//Meaning it compares one of the last ones it compared.
		foodLamb.sort((foodA, foodB) -> Food.compare(foodA, foodB));
		System.out.println(foodLamb);
	}
	private static void sortByMethR() {
		List <Food> foodMRef = Food.getFoods();
		//This does the same thing but with less code.
		foodMRef.sort(Food::compare);
		System.out.println(foodMRef);
	}
	//After some thought I have decided to skip the next portion of this assignment as it does not seem worth focusing on.
	//I will instead continue practicing my side project and implementing recursion into it, I hope you understand.
	
}
