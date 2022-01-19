

public class Test {

	public static void main(String[] args) throws Exception {
		
		Deck a = new Deck ();
		Player pOne = new Player ("Trevor");

		a.shuffle();
		
		pOne.draw(a);
		pOne.draw(a);
		pOne.draw(a);
		pOne.draw(a);
		pOne.draw(a);
		pOne.draw(a);
		System.out.println(pOne.desribe());
		pOne.incrementScore();
		System.out.println(pOne.desribe());
		System.out.println(pOne.flip().describe());
		System.out.println(pOne.desribe());
	}
}
