/**
*****************************************************
  This is the Player class for the Video Poker program.
  Template provided by Dr. Cannon

  COMSS 1004 JAVA - Homework 4: Programming Project
  written William J. Reid
  UNI: wjr2118
  Date: June 16, 2016
******************************************************
*/

import java.util.ArrayList;

public class Player {


	private ArrayList<Card> hand; // the player's cards
	// you will likely need more instance variables
	private int numberOfCards;


	public Player(){
		// create a player here
		numberOfCards = 0;
		hand = new ArrayList<Card>(); // A player consists of a hand of 5 cards.
	}

	public void addCard(Card c){ // The "addCard()" method  adds a card to the ArrayList "hand"
		hand.add(c); // Adds the card to the player's hand.
		numberOfCards++;
	}

	public void removeCard(Card c){ //The "removeCard()" method removes a card to the ArrayList "hand"
		if (numberOfCards != 0){
				hand.remove(c); // Removes the card to the player's hand.
				numberOfCards--;
		}
	}

	public ArrayList<Card> getPlayersHand(){ // Returns the players hand.
			return hand;
	}
}
