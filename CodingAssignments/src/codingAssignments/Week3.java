package codingAssignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week3 {

	public static void main(String[] args) {
		
//------------------------------Create an array of int called ages that contains the following values: 3, 9, 23, 64, 2, 8, 28, 93 [Step 1]------------------------------------//
		
		Integer[] ages = {3, 9, 23, 64, 2, 8, 28, 93};
		
//-------------------------------------value of last in array (7 at the moment) minus value of first in array (always 0) [Step 1 a]-------------------------------------------//
		
		//I found it interesting I have to add -1 here since arrays are 0 based and I guess .length is not. .length reads it as 1-8 rather than 0-7.
		System.out.print("Last value minus first: ");
		System.out.println(ages [ages.length-1] - ages [0]); 
		
//-------------------------Add a new age to your array and repeat the step above to ensure it is dynamic (works for arrays of different lengths) [Step 1 b]----------------------//
		
		//The new value I want to add
		int newValue = 20;
		//Create a new ArrayList called tempAL from the array
        List<Integer> tempAL= new ArrayList<Integer>(Arrays.asList(ages));
        //Adds newValue to the arraylist. This begs the question why use an array over arrayList. Looks like the reason is it uses more memory.
        tempAL.add(newValue);
        //Make it back into an array
        ages = tempAL.toArray(ages);
		//Moment of truth This should be 20-3
        System.out.print("Last value minus first with new value: ");
		System.out.println(ages [ages.length-1] - ages [0]); 
		
//------------------------------Use a loop to iterate through the array and calculate the average age. Print the result to the console. [Step 1 c]-------------------------------//
		
		int ageAverage = 0;
		//this loop adds all the values in the arrays together. It will work with any length array because i<age.length will change dynamically
			for (int i = 0; i < ages.length; i++) {
				
				//0+3 loop 3+9 loop 12+23 loop 35+64 loop so on..
				ageAverage = ages [i]+ ageAverage;
			}
		ageAverage = ageAverage / ages.length;
		System.out.println("Average age: " + ageAverage);
		
//------------------------Create an array of String called names that contains the following values: “Sam”, “Tommy”, “Tim”, “Sally”, “Buck”, “Bob”. [Step 2]-------------------------//
		
		String[] names = {"Sam", "Tommy", "Tim", "Sally", "Buck", "Bob"};
		
//----------------------Use a loop to iterate through the array and calculate the average number of letters per name. Print the result to the console. [Step 2 a]-------------------//
		
		int nameAverage = 0;
		//Same loop as earlier but changed age [i] to names [i].length to convert the String into an int
			for (int i = 0; i<names.length; i++) {
				
				nameAverage = names [i].length()+ nameAverage;
			}
			nameAverage = nameAverage / names.length;
			System.out.println("Average letters in names: " + nameAverage); 
			
//-------------Use a loop to iterate through the array again and concatenate all the names together, separated by spaces, and print the result to the console. [Step 2 b]-------------//
		
		String allNames = "";
			for (int i = 0; i<names.length; i++) {
				
				allNames = names [i] + " " + allNames;
			}
		System.out.println(allNames);
		
//--Create a new array of int called nameLengths. Write a loop to iterate over the previously created names array and add the length of each name to the nameLengths array. [Step 5]--//
		
		//I learned here that even while arrays are 0 based the count after new int is not.
		int[] nameLengths = new int [6];
		
		//For loop that goes as many times as the amount of entries in the array "names"
		for (int i = 0; i < names.length; i++) {
			
			//first pick the place in the array to assign, than assigns the value of another array converted from a String to an int that is the amount of lettlers in said string.
			nameLengths [i] =names [i].length();
			
		}
		
//----------------Write a loop to iterate over the nameLengths array and calculate the sum of all the elements in the array. Print the result to the console. [Step 6]----------------//
		
		//I got mixed up this time around and typed "i < nameLengths [nameLengths.length]" by accident. Returning 3. 
		//I knew the loop wasn't running enough times from the result I got. Figured out what was happening with a print of nameLengths [nameLengths.length].
		int result = 0;
		//Adds result to what i equals in the array than stores that, loops, increments i, and adds that result to the next value of i.
		for (int i = 0; i < nameLengths.length; i++) {
			
			result = result + nameLengths [i];
		}
		System.out.println("Sum of all letters above: " + result);
		
//----------------Write a method that takes a String, word, and an int, n, as arguments and returns the word concatenated to itself n number of times. [Step 7]--------------------//
		
		//calls method ("String word", int n) The method is on line 106
		concatString ("hello", 3);
		
//---------------------------------------Write a method that takes two Strings, firstName and lastName, and returns a full name [Step 8]---------------------------------------------//
		
		//call method (String first, String last) The method is on line 126
		fullName ("Trevor", "Young");
		//It creates the space in the String so you do not have to enter it every time you call the method.
		
//-------------------------Write a method that takes an array of int and returns true if the sum of all the ints in the array is greater than 100. [Step 9]---------------------------//
		
		//call method (int array) The method is on line 134.
		arraySumCheck (ages);
		
//---------------------------------Write a method that takes an array of double and returns the average of all the elements in the array. [Step 10]------------------------------------//
		
		//test double array.
		double [] avgTest = {1.1,1.1,9.9,1.1,1.1};
		//Make a new double that will be the average of call method (double array). method is on line 159. The "1" is there because I'm using it in step 11 as well.
		double d1Result = averageDouble (avgTest);
		//Print d1result, the return value of the method.
		System.out.println("[Step 10] Average of avgTest: " + d1Result);
		
//Write a method that takes two arrays of double and returns true if the average of the elements in the first array is greater than the average of the elements in the second array. [Step 11]//
		
		//2nd test double array to be compared. 1st is in Step 10.
		double [] avgTest2 = {5.5,5.5,5.5};
		//Create the boolean to catch the return of the method that will compare the two doubles.
		boolean avgCompare = avgDoubleCompare (avgTest, avgTest2);
		System.out.println("[Step 11] Is avgTest>avgTest2: "+ avgCompare);
		//Swap places of the two double arrays to ensure method works.
		avgCompare = avgDoubleCompare (avgTest2, avgTest);
		System.out.println("Swap avgTest2>avgTest to ensure method works: "+ avgCompare);
		
//Write a method called willBuyDrink that takes a boolean isHotOutside, and a double moneyInPocket, and returns true if it is hot outside and if moneyInPocket is greater than 10.50. [Step 12]//
		
		//Set if it's hot and my true amount of money I wish I had.
		boolean isHotOutside = true;
		double moneyInPocket = 100000000.50;
		//Create the boolean to catch the return of the method that will only resolve true if boolean is true and double is over 10.50.
		boolean getDrink = willBuyDrink (isHotOutside, moneyInPocket);
		System.out.println("[Step 12] Will I get a Drink: "+getDrink);
		
//----------------------------------------Create a method of your own that solves a problem. In comments, write what the method does and why you created it.---------------------------------//
		
		//Calling a method to do HP checks and updates and give different messages or even end the game depending on HP level.
		int hp = 100;
		System.out.println("HP="+hp);
		System.out.println("Ouch! A rock landed on your toe! -50HP");
		//This updates the HP to lower amount since user took damage. The second int is the damage.
		hp = hpUpdate(hp,-50);
		System.out.println("You eat an apple. +2HP");
		//It also handles the console outputs and works with healing too!
		hp = hpUpdate(hp,2);
		//It says HP critical when under 30HP
		System.out.println("The rocks back! -50HP");
		hp = hpUpdate(hp,-50);
		//It will end normally after HP is 0 but if you go under -100 It makes fun of you.
		System.out.println("The worlds gravity changes. -500HP");
		hp = hpUpdate(hp,-500);
	}

	public static void concatString(String word, int n) {
	//^We still haven't gone in depth what public static void is but concat string is the name of the method, () are the values mentioned when calling the method.
		
		//this is acting as my result String.
		String concat = "";
		
		//loops as long as i is less than or equal to n and increments i.
		for (int i = 1; i <= n; i++) {
			
			//This is where the magic happens, takes our "concat" that starts as nothing, that way it can work with any input, than tacks on 1 more "word" each loop.
			concat = word + concat;
		}
		System.out.println(concat);
	}
	public static void fullName (String first, String last) {
		
		//Make a new String "fullname" by adding first and " " and last Strings together.
		String fullName = first + " " + last;
		System.out.println(fullName);
	}
	public static void arraySumCheck (Integer[] a) {
	//Brings an integer into the methods scope and assigns it "a"
		
		boolean over100 = false;
		int result = 0;
		for (int i = 0; i < a.length; i++) {

			result = result + a[i];
		}
		if (result > 100) {
			over100=true;
		}
		System.out.println("[Step 9] Sum of array= "+ result + ". Over 100? "+over100);	
	}
	public static double averageDouble (double[] a) {

		
		//I reused code from step 1 c and changed a few variables to make it compatible with double
		//this loop adds all the values in the arrays together. It will work with any length array because i < a.length will change dynamically
		double result = 0;
			for (int i = 0; i < a.length; i++) {
				
				result = a [i]+ result;
			}

		result = result / a.length;
		//return result as a double (specified in "public static ->double<-")
		return result;
		
	}
	public static boolean avgDoubleCompare (double[] a, double[] b) {
		
		//this is the boolean that will be sent back on the return statement.
		boolean greater2 = false;
		//A method in a method. I'm basically doing the same thing as Step 10 here.
		double result1 = averageDouble (a);
		//Repeat last line to get the average of the second array.
		double result2 = averageDouble (b);
			//Finally, compare the two.
			if (result1>result2)
				greater2=true;
		
		//Send back the true/false statement.
		return greater2;
	}
	public static boolean willBuyDrink (boolean boo, double duo) {
		
		//boolean to be returned weather or not to get a Drink.
		boolean get = false;
			//Only resolves true if boolean is true and double is over 10.50.
			if (boo==true && duo>10.50) 
				get=true;
		//Send the boolean to method call.
		return get;
	}
	public static int hpUpdate(int hp, int hpUpd) {
		
		//Where the HP change occurs
		hp=hp+hpUpd;
		
			//This is where all the magic I mentioned in the main method happens.
			if (hp<=-100){
				System.out.println("HP="+hp+" Bro you got rolled lul. Game Over.");
				System.exit(0);
			}else if (hp<=0){
				System.out.println("HP="+hp+" Game Over");
				System.exit(0);
			}else if (hp<=30){
				System.out.println("HP="+hp);
				System.out.println("Warning! HP Critical!");
			}else {
				System.out.println("HP="+hp);
			}
		return hp;
	}
	
}