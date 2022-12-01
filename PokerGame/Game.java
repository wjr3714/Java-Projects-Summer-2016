/**
*****************************************************
  This is the Game class for the Video Poker program.
  Template provided by Dr. Cannon

  COMSS 1004 JAVA - Homework 4: Programming Project
  written William J. Reid
  UNI: wjr2118
  Date: June 16, 2016
******************************************************
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;
import java.util.Collections;

public class Game {

	private Player p; // Instantiates a player.
	private Deck cards;
	private ArrayList<Card> hand; // Instantiate the player's hand. The player's hand will consist of 5 cards.
	// you'll probably need some more here


	public Game(String[] testHand){
		// This constructor is to help test your code
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace - king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush

		p = new Player();
		cards = new Deck();
		cards.shuffle();
		createPlayersHand(testHand);

		hand = new ArrayList<Card>(p.getPlayersHand()); // The intention of the variable "hand" is  to create a copy of the player's hand.
		// This is particularly useful as we don't want to prevent overwriting the player's actual hand while we analyze it, and later
		// remove/add any cards that the player specifies.
		System.out.println(checkHand(hand));
	}

	public Game(){
		// This constructor is to actually play a normal game
		p = new Player();  // Creates a Player object.
		cards = new Deck(); // Creates a new deck.
		cards.shuffle();  // Shuffles the cards.

		for(int i=0; i<5; i++){ // Deals 5 cards to the player.
				p.addCard(cards.deal());
		}

		hand = new ArrayList<Card>(p.getPlayersHand()); // The intention of the variable "hand" is  to create a copy of the player's hand.
		// This is particularly useful as we don't want to prevent overwriting the player's actual hand while we analyze it, and later
		// remove/add any cards that the player specifies.

	} // End of Game() method.

	public void play(){
		// this method should play the game

		System.out.println("\nWelcome to Video Poker! \n");
		System.out.println("Your hand is:\n");
		Scanner s = new Scanner(System.in);

		int j = 0; // Used to print a number next to the card in the player's hand (purpose: better readability for the player.)

		// The for loop (below) will print each card of the plaeyr's hand.
		for (Card element: hand){  // The enhanced for loop, details on pg. 321 of the Big Java Textbook
			j++;
			System.out.println(j + ". " + element); //The toString method in the Card class converts this to a string.
		}

		System.out.println("\nWould you like to keep your hand or request new cards?");
		System.out.println("NOTE: Enter only the integer (0 or 1) corresponding to your decision!");
		System.out.println("Use the following code scheme: \n");
		System.out.println("\t 0 - Remove zero cards.");
		System.out.println("\t 1 - Remove some cards. \n");
		System.out.println("Enter your decision here: ");

		int change = s.nextInt(); // The variable "change" stores the number of cards to be rejected

		if (change == 1){  // If the user asks to change cards, this if-statement will be called.
			System.out.println("\nHow many cards would you like replaced? (Enter a number between 1-5)");
			System.out.println("NOTE: If you changed your mind and want no cards replaced, please enter 0.\n");
			System.out.println("Please enter your decision here: ");
			int howManyCards = s.nextInt();
			if (howManyCards == 5){
				// Removes the five cards one by one. This way the user doesn't have to enter the five
				// cards he wants replaced (there are a total of five cards in his/her hand) meaning
				// that he wants all of them removed.
				p.removeCard(hand.get(howManyCards-1));
				p.removeCard(hand.get(howManyCards-2));
				p.removeCard(hand.get(howManyCards-3));
				p.removeCard(hand.get(howManyCards-4));
				p.removeCard(hand.get(howManyCards-5));

				// Gives the player 5 new cards, one at a time.
				p.addCard(cards.deal()); // Deals the player 1 new card.
				p.addCard(cards.deal()); // Deals the player 1 new card.
				p.addCard(cards.deal()); // Deals the player 1 new card.
				p.addCard(cards.deal()); // Deals the player 1 new card.
				p.addCard(cards.deal()); // Deals the player 1 new card.
			}
			else{
				for(int i=0; i < howManyCards ; i++){ // Asks the player what cards he wants to reject.
						System.out.println("What card do you want to reject? (Please enter: 1, 2, 3, 4, or 5)");
						int changeCardInHand = s.nextInt();

						p.removeCard(hand.get(changeCardInHand-1)); // Removes the specified card.
						p.addCard(cards.deal()); // Replaces the previously discarded card.
				}
			}
		}

		hand = new ArrayList<Card>(p.getPlayersHand()); // The intention of the variable "hand" is  to create a copy of the player's hand.
		// This is particularly useful as we don't want to prevent overwriting the player's actual hand while we analyze it, and later
		// remove/add any cards that the player specifies.

		System.out.println("\nYour final hand is:\n");
		int k = 0;
		for (Card element: hand){ // The new hand is printed.
			k++;
			System.out.println(k + ". " + element);
		}

 		String crossCheckResult = checkHand(hand); // Lastly, we rank the hand of the player and return the result.
		System.out.println(crossCheckResult);
	}


/**
 The checkHand method stated that it should :
 take an ArrayList of cards as "s" and then determine what that evaluates
 to and return that as a String". That is why we chose "s" as the parameter of
 the method below.
*/
	public void print(String s){ // This method facilitates the printing
			System.out.println(s);   // of a string when the player is asked
															// which cards does he/she want removed.
	}


	public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards
		// as s and then determine what evaluates to and
		// return that as a String

		hand = sortPlayersHand(hand);   // Sorting the hand first facilitates evaluating
																		// the players hand. (Makes the code easier to write.)

		/** The reason for starting with the best possible hand in the block of code below
				is so that only the highest possible rank is returned, as often times in Poker
				a higher hand contains one or more of the other possible hands (for example, a full house
				consists of a pair and a three of a kind.) If the "pair" block or "three of a kind" block
				were to come before the "full house" block, the player would be told that he/she has a pair,
				a three of a kind, or both (in addition to a full house).
		*/
		if (royalFlush(hand)==true){
				return "\nYou have a royal flush! Payout: $250 \n";
		}
		else if (straightFlush(hand)==true){
				return "\nYou have a straight flush! Payout: $50 \n";
		}
		else if (fourOfAKind(hand)==true){
				return "\nYou have a four of a kind! Payout: $25 \n";
		}
		else if(fullHouse(hand)==true){
				return "\nYou have a full house! Payout: $6 \n";
		}
		else if (flush(hand)==true){
				return "\nYou have a flush! Payout: $5 \n";
		}
		else if (straight(hand)==true){
				return "\nYou have a straight! Payout: $4 \n";
		}
		else if (threeOfAKind(hand)==true){
				return "\nYou have a three of a kind! Payout: $3 \n";
		}
		else if (twoPairs(hand)==true){
				return "\nYou have 2 pairs! Payout: $2 \n";
		}
		else if (onePair(hand)==1){  // "pair" is of type int because we must keep track
															// of how man pairs are contained in the hand.
				return "\nYou have 1 pair! Payout: $1 \n";
		}
		else{
				return "\nYou have no pairs. \n";
		}
	}


/** We must think of the methods that rank the hand (below) as checkpoints, starting at
the lowest possible hand (a pair) and moving on to the highest. Thinking of them as
checkpoints allows us to use the value that a specific method returns to check whether
a different (higher) rank is possible or not. For example:

Three of a kind: Contains (pair)
Full House: Contains (pair + three of a kind)
Four of a kind: Contains (pair + pair, but it also contains a three of a kind)

etc...
*/
	public int onePair(ArrayList<Card> hand){ // "pair" is of type int because we must keep track of how man pairs are contained in the hand.
			Card temporaryVariable;
			int i=1;
			int numberPairs=0;
			while (i<hand.size()){
					temporaryVariable = hand.get(i-1);
					if (temporaryVariable.isValueTheSame(hand.get(i))){
							i++;
							numberPairs++;
					}
					i++;
			}
			return numberPairs;  // Returns the total number of pair found.
	} // End of one pair method.

	public boolean twoPairs(ArrayList<Card> hand){
			if(onePair(hand)==2){  // If two pairs were found in the method "pair", it will return true, and false otherwise.
					return true;
			}
			else{
					return false;
			}
	} // End of twoPairs method.

	public boolean threeOfAKind(ArrayList<Card> hand){
			if (onePair(hand)==0){ // A three of a kind must have passed the "pair" checkpoint.
					return false;
			}
			// Checks whether any of the first three cards is the same as a card two indeces down.
			// This works because since the cards are sorted, a pair is bound to be next to each other.
			// Thus, if another card of the same value is found and that cards is not adjacent to the other cards,
			// than we can be sure that there are at least three cards of the same value in the player's hand.
			else if( hand.get(0).isValueTheSame(hand.get(2)) || hand.get(1).isValueTheSame(hand.get(3)) || hand.get(2).isValueTheSame(hand.get(4))){
							return true;
					}
			else {
					return false;
			}
	} // End of three of a kind method.

	public boolean straight(ArrayList<Card> hand){

			Card firstCardOfPlayersHand = hand.get(0); // Get the first player's hand.
			Card secondCardOfPlayersHand = hand.get(1); // Get the second player's hand.
			Card fifthCardOfPlayersHand = hand.get(4); // Get the fifth player's hand.

			if (onePair(hand) > 0){ // For a straight to be possible, no pairs can exist.
					return false;
			}

			// Since the cards are sorted, the difference of the first card and the last must be of magnitude equal to 4.
			else if(fifthCardOfPlayersHand.howFarApartAreTheCards(firstCardOfPlayersHand) == 4){
					return true;
			}

			// Here, an Ace can count as a card that comes after the King.
			else if(firstCardOfPlayersHand.getValue()==1 && secondCardOfPlayersHand.getValue()==10 && fifthCardOfPlayersHand.getValue()==13){
					return true;
			}
			else{
					return false;
			}
	} // End of straight method.

	public boolean flush(ArrayList<Card> hand){
			if(onePair(hand) > 0){ // It is impossible for a pair to have the same suit.
					return false;
			}
			else{
						int i=1;
						for (Card element: hand){
							/** Since the cards are sorted, if two neighboring cards don't have
									the same suit, then we have proved that the hand does not have a flush
							*/
							if (! element.isSuitTheSame(hand.get(i))){
									return false;
							}
							if(i<hand.size()-1){
									i++;
							}
					}
					return true;
			}
	} // End of flush method

	public boolean fullHouse(ArrayList<Card> hand){
		// A full house cannot not have a four of a kind. It consists of a pair and a three of a kind.
			if (onePair(hand)==2 && threeOfAKind(hand)==true && fourOfAKind(hand)==false){
					return true;
			}
			else{
					return false;
			}
	} // End of fullHouse method

	public boolean fourOfAKind(ArrayList<Card> hand){
			if (onePair(hand)==2 && threeOfAKind(hand)==true){
					if(hand.get(0).isValueTheSame(hand.get(3)) || hand.get(1).isValueTheSame(hand.get(4))){  // Allows to differentiate from a full house
							return true; // Returns "true" if there are four hands of the same value in the hand
					}
			}
			return false;
	} // End of fourOfAKind method.


	public boolean straightFlush(ArrayList<Card> hand){
			if ((flush(hand) == true) && (straight(hand) == true)){ // The player must have both a flush and straight for condition to hold true.
					return true;
			}
			else{
					return false;
			}
	} // End of straightFlush method.

	public boolean royalFlush(ArrayList<Card> hand){
			if (straightFlush(hand)==true && ((hand.get(0).getValue()==1) || (hand.get(0).getValue()==14))){
				// The Ace can be both the lowest card (1) or the highest card (14)
					return true; // Returns true if the hand contains a royal flush, and false otherwise.
			}
			else{
					return false;
			}
	} // End of royalFlush method.

	// This method sorts the hand and returns it.
	public ArrayList<Card> sortPlayersHand(ArrayList<Card> hand){
			Collections.sort(hand);
			return hand;
	}

/** The createPlayersHand() creates the player's hand,
		where the suit corresponds to the first character of the array and the value
		is the last part of the string, as indicated by Dr. Cannon:

		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace - king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
*/

	public void createPlayersHand(String[] testHand){


			int suit = 0;  // first character of the array
			int value = 1; // second character of the array
			char characterListOfSuits;
			Card aCard;
			String cardValueConvertedToString;

			for(int i=0; i<5; i++){
					characterListOfSuits = testHand[i].charAt(0);
					cardValueConvertedToString = testHand[i].substring(1);

					value = Integer.parseInt(cardValueConvertedToString);
					if ((characterListOfSuits=='c') || (characterListOfSuits=='C')){
							suit=1;
					}
					else if ((characterListOfSuits=='d') || (characterListOfSuits=='D')){
							suit=2;
					}
					else if ((characterListOfSuits=='h') || (characterListOfSuits=='H')){
							suit=3;
					}
					else if ((characterListOfSuits=='s') || (characterListOfSuits=='S')){
							suit=4;
					}
					else{
						System.out.println("There is no such suit!");
					}

					aCard = new Card(suit, value);
					p.addCard(aCard);
			}
	}
}
