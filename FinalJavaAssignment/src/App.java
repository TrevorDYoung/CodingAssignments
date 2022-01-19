
public class App {

	public static void main(String[] args) {
		
		Deck a = new Deck ();
		Player pOne = new Player ("Trevor");
		Player pTwo = new Player ("Tyler");

		a.shuffle();
		
			for (int i = 0; i < 52; i++) {
				
				if (i % 2 == 0) {
					
					pOne.draw(a);
				}else {
					
					pTwo.draw(a);
				}
			}
			for (int i = 0; i < 26; i++) {
				
				//Checks if the value of p1 hand is greater than that of p2.
				if (pOne.flip().getValue() > pTwo.flip().getValue()) {
					
					pOne.incrementScore();	//if so adds score p1.
				}else {
					
					pTwo.incrementScore();	//if not adds p2.
				}
			}
			if (pOne.getScore() > pTwo.getScore()) {
				
				System.out.println("Player 1 wins a new car!");
			}else if (pOne.getScore() == pTwo.getScore()) {
				
				System.out.println("It's a draw! Lame!");
			}else {
				
				System.out.println("Player 2 wins a free meal!");
			}
	}

}
