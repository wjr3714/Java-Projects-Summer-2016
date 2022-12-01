/**
*****************************************************
  This is the Card class for the Video Poker program.
  Template provided by Dr. Cannon

  COMSS 1004 JAVA - Homework 4: Programming Project
  written William J. Reid
  UNI: wjr2118
  Date: June 16, 2016
******************************************************
*/

public class Card implements Comparable<Card>{

	private int suit; // use integers 1-4 to encode the suit
	private int value; // use integers 1013 to encode the value

	public Card(int s, int v){
		//make a card with suit s and value v
		suit = s;
		value = v;
	}

	public int compareTo(Card c){
		// use this method to compare cards so they
		// may be easily sorted


		/** The suit ranking used in the game of bridge is (ascending alphabetical order):
				clubs (lowest), followed by diamonds, hearts, and spades (highest).
		*/
		/** We first compare the value of the card (i.e., Ace, 1, 2, 3,...,King)
				By subtracting the value, we will know if the cards have the same value if and only if their difference is equal to 0.
				We will know whether the card passed in is greater in value if the difference is a positive integer.
				And we will know the the card passed in is smalled in value if the difference is a negative integer.
		*/
		int cardComparison = this.value - c.getValue(); // The "this.value" refers to the instance variable "value" of the Card class
		//We will have to create a method to get the value of the Card passed into the compareTo method.
		// For now, call it getValue() in order to follow standard practice notation.

		if (cardComparison == 0){ // We will only compare the cards by their suit
			// if and only if their values were the same, that is, if theri difference in the line above was equal to zero.
			cardComparison = this.suit- c.getSuit();// The "this.suit" refers to the instance variable "suit" of the Card class
			//We will have to create a method to get the suit of the Card passed into the compareTo method.
			// For now, call it getSuit() in order to follow standard practice notation.
		}
		return cardComparison;

	}


	public String toString(){
		// use this method to easily print a Card object

		String valueOfCard = "";
		String typeOfSuit = "";

		/** We were instructed to code the suits in following way: "use integers 1-4 to encode the suit"
				For better code readability, the smallest integers will represent the first name of the suit
				in order of alphabetical appearance.
		*/
		if (suit == 1){
			typeOfSuit = "Clubs";
		}
		else if (suit == 2){
			typeOfSuit = "Diamonds";
		}
		else if (suit == 3){
			typeOfSuit = "Hearts";
		}
		else if (suit == 4){
			typeOfSuit = "Spades";
		}
		else{
			System.out.println("No cards exist of the specified suit.");
		}

		//We now have to give the string the actual value of card.
		if ((value > 1) && (value < 11)){ // Used to assign the values of the cards whose valuue is in the range 2 through 10, exclusive.
			valueOfCard = "" + value;
		}

		else if(value == 11){
				valueOfCard = "Jack";
		}

		else if(value==12){
				valueOfCard = "Queen";
		}

		else if(value==13){
				valueOfCard = "King";
		}

		else if((value == 1) || (value == 14)){ // The Ace can be both the highest card or the lowest card.
				valueOfCard = "Ace";
		}

		String cardName = valueOfCard + " of " + typeOfSuit;  // For example, this will store the card as: "Ace of Hearts", "10 of Spades", etc...
		return cardName;
	}
	// add some more methods here if needed

// getValue() is an accessor method to get the value of the card (Ace, 2, 3,4,5,6,...,Queen, King, Ace)
	public int getValue(){
		/** This method will be used to return the value of a card. It is important to create this method in order
		 		for other methods in other classes to have access to the value of a particular card. For such reason, this method is "public" and
		 		it allows us to access the instance variable "value" (which is private to this class only). */
			return value;
	}
	// getSuit() is an accessor method to get the integer value of the suit, where a 1=Clubs, 2=Diamonds, 3=Hearts, 4=Spades)
	public int getSuit(){
		/** This method will be used to return the suit of a card. It is important to create this method in order
			  for other methods in other classes to have access to the suit of a particular card. For such reason, this method is "public" and
			  it allows us to access the instance variable "suit" (which is private to this class only).
		*/
			return suit;
	}

	// This method will be helpful for determining if the user has a pair, a three of kind, and therefore a full house (a pair + three of a kind).
	public boolean isValueTheSame(Card c){ // If the cards have the same value, the method "isValueTheSame()" will return true, and false otherwise.
			return this.value == c.getValue();
	}

	// This method will be useful for determining if the player has a flush &/or a straight flush
	public boolean isSuitTheSame(Card c){ // If the cards have the same suit, the method "isSuitTheSame()" will return true, and false otherwise.
			return this.suit == c.getSuit();
	}

	// This method will be useful for determining if the player has a straight &/or a straight flush
	public int howFarApartAreTheCards(Card c){ // We take the difference of the two cards to determine how far apart the cards are from each other.
			return this.value - c.getValue(); // If the difference is either 1 or -1, there will be a possibility for a straight (if all five cards have such a differnce among each other.)
	}
}
