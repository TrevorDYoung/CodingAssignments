import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	//I think a constructor in the Card class should be better to make the deck but It didn't seem like the desired way.
	private ArrayList <Card> deck = new ArrayList <>();{

		for (int i = 1; i <= 52; i++) {
		
			//Creates 52 instances of the class Card and assigns their values.
			deck.add(new Card ());
			if (i <= 13) {
					//try catch for the assignment of the cards by the loop.
					try {       //Sets the face.
						deck.get(i-1).setValue(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {		//Sets the suit.
						deck.get(i-1).setName("Hearts");
					} catch (Exception e) {
						e.printStackTrace();
					}
			}else if (i <= 26) {
				
					try {			//I subtract 13 from loop int value since i needs to assign a new suit.
						deck.get(i-1).setValue(i-13);
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						deck.get(i-1).setName("Diamonds");
					} catch (Exception e) {
						e.printStackTrace();
					}
			}else if (i <= 39) {
				
					try {
						deck.get(i-1).setValue(i-26);
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						deck.get(i-1).setName("Spades");
					} catch (Exception e) {
						e.printStackTrace();
					}
			}else if (i <= 52) {
				
					try {
						deck.get(i-1).setValue(i-39);
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						deck.get(i-1).setName("Clubs");
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
			
		}
	}
	public void shuffle () {
		
		//built in method that shuffles any list in java.
		Collections.shuffle(deck);
	}
	public Card draw () {
	
		//Uses a built in method to remove the top card and returns it.
		return this.deck.remove(0);
	}
	
}
