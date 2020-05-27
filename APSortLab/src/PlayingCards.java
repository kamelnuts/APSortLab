public class PlayingCards extends Generics {
	public static final String type = "Cupcakes";
	public enum KeyType {combo, number, suit, color};
	public static KeyType key = KeyType.combo;
	private String suit;
	private String number;
	private String color;
	
	PlayingCards(String number, String suit, String color)
	{
		this.setType(type);
		this.suit = suit;
		this.number = number;
		this.color = color;
	}
	
	/* 
	 * toString provides output based off of this.key setting
	 */
	@Override
	public String toString() {		
		String output="";
		switch(key) {
		case number:
			output += this.number;
			break;
		case color:
			output += this.color;
			break;
		case suit:
			output += this.suit;
			break;
		case combo:
		default:
			output = type + ": " + this.number + " of " + this.suit + " (" + this.color + ")";
		}
		return output;
	}
	
	public static Generics[] playingCardsData() {
		Generics[] cc = { 
				new PlayingCards("4", "Clubs", "Black"),
				new PlayingCards("5", "Spades", "Black"),
				new PlayingCards("King", "Diamonds", "Red"),
				new PlayingCards("King", "Hearts", "Red"),
				new PlayingCards("Ace", "Spades", "Black"),
				new PlayingCards("5", "Hearts", "Red"),
				new PlayingCards("4", "Spades", "Black"),
				new PlayingCards("3", "Diamonds", "Red"),
				new PlayingCards("Jack", "Clubs", "Black"),
		};
		return cc;
	}
	
	public static void main(String[] args)
	{
		Generics[] cc = playingCardsData();
		for(int i = 0; i < cc.length; i++)
			System.out.println(cc[i]);
	}
	
}
