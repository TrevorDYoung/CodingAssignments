
public class Card {

	private int value;
	private String name;
	
	//My setter for the value checks if the number given is in range and throws an exception if not.
	public void setValue (int value) throws Exception {
		
		if (value <= 13 && value >= 1) {
			
			this.value = value;
		}else {
			throw new Exception ("Number is out of bounds, must be 1-13!");
		}
	}
	public int getValue () {
		
		return this.value;
	}
	//returns for example "Ace of spades" I programmed this setter so all you have to give it is its suit.
	public void setName (String name) throws Exception {
		
	//Checks that name is either "Hearts" "Diamonds" "Spades" or "Clubs".
		if (name.equals("Hearts") || name.equals("Diamonds") || name.equals("Spades") || name.equals("Clubs")) {
			
		}else {
			
			throw new Exception ("Only acceptable names are \"Hearts\" \"Diamonds\" \"Spades\" or \"Clubs\" case sensitive.");
		}
		
	//Checks if the value is a face card and if so assigns it its name. For example if its 1, 
	//it will rename it Ace. And throws exception if value is not yet set.
		if (value == 0) {
			
			throw new Exception(".setName requires you to .setValue first!");
		}else if (value >= 2 && value <= 10) {
		
			this.name = (value + " of " + name);
		}else if (value == 13) {
			
			this.name = ("King of " + name);
		}else if (value == 12) {
			
			this.name = ("Queen of " + name);
		}else if (value == 11) {
			
			this.name = ("Jack of " + name);
		}else if (value == 1) {
			
			this.name = ("Ace of " + name);
		}
	}
	public String getName() {
		
		return this.name;
	}
	//Descriptor, returns the class name meaning the name of the class. Than it concats in the variables.
	public String describe () {
		
		return getClass().getName() + " " + this.name + " " + this.value;
	}
	
}
