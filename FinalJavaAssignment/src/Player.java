import java.util.ArrayList;

public class Player {

	private ArrayList <Card> hand = new ArrayList <>();
	private int score;
	private String name;
	
	//constructor setting player name and score to 0. int default value in java is 0.
	public Player (String name) {
		
		this.name = name;
	}
	public String desribe () {
		
		//Creates a String that lists all the cards with commas.
		String cards = "";
			for (int i = 0; i < this.hand.size(); i++) {
			
				if (i == this.hand.size()-1) {
					
					cards = cards + this.hand.get(i).describe();
				}else {
					
					cards = cards + this.hand.get(i).describe() + ", ";
				}
			}
		return this.name + " " + this.score + " " + cards;
	}
	//Removes and returns top card in hand.
	public Card flip () {
		
		return this.hand.remove(0);
	}
	//Draws from deck and adds card to hand.
	public void draw (Deck a) {
		
		this.hand.add(a.draw());
	}
	public void incrementScore () {
		
		this.score++;
	}
	public int getScore () {
		
		return this.score;
	}
	public int cardCount () {
		
		return hand.size();
	}
}
