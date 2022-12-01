/**
*****************************************************
  This is the Deck class for the Video Pokder program.
  Template provided by Dr. Cannon

  COMSS 1004 JAVA - Homework 4: Programming Project
  written William J. Reid
  UNI: wjr2118
  Date: June 16, 2016
******************************************************
*/

public class Deck {

	private Card[] theDeck;
	private int top; // the index of the top of the deck
	// add more instance variables if needed

	public Deck(){
		// make a 52 card deck here

		top = 0;  // Index of the top of the deck
		int amountOfCardsInDeck = 0; // Will be used to access the index of the
		theDeck = new Card[52]; // Creates an Array that will hold a deck of 52 cards
		Card card;

		// The nested for loop (below) are responsible for creating all the cards and adding them to "theDeck"
		for (int digitValue = 1; digitValue <= 13; digitValue++){ // Makes sure that all values (Ace, 2, 3, 4, ..., King) are created.
			for (int suitType = 1; suitType <= 4; suitType++){ // There are four possible suit types (ranging from 1 - 4 that correspond to clubs, diamonds, hearts, and spades, respectively.)
					card = new Card(suitType, digitValue); // Creates a new card of value[i] and suit[j]
					theDeck[amountOfCardsInDeck]= card; // Adds the card to the deck starting at index[0] (that is why we instantiate the variable: "amountOfCardsInDeck = 0")
					amountOfCardsInDeck++; // Updates the index so that the next card is added on the index that follows.
			}
		}
	}

	public void shuffle(){
		// shuffle the deck here
		Card temporaryVariable;
		for (int i=0; i<99999; i++){ // We will randomly swap the top card of the deck 99999 times, thus shuffling the deck.
				int randomLocationInDeck = (int)(Math.random()*52); // The variable "randomLocationInDeck" will be used to access a random index between 1 and 52.

				/** As explained on pg. 326 of the Textbook Big Java - Early Objects by Horstmann,
				 		two swap the first card of the deck with another at a randomly chosen index,
						we must create a temporary variable to store the original value at index i. We must do this
						in order to avoid such data point to be overridden.
				*/
				temporaryVariable=theDeck[0]; // theDeck[0] refers to the first card of the deck (at index = 0).
				theDeck[0]=theDeck[randomLocationInDeck]; // Here we copy a random card in the deck to the top location in the deck.
				// At this point, there now exists two instances of the card at location [randomLocationInDeck].
				// We must use the temporaryVariable to overwrite the card that was moved to the top of the deck at its original location [randomLocation]
				theDeck[randomLocationInDeck]=temporaryVariable; // At this point, the top card has been swaped with the one the index[randomLocation]
		}
	}

	public Card deal(){
		// The condition to be met is that we must always deal the top card of the deck.
		top++;
		return theDeck[top-1];
	}
}
