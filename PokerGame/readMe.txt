Homework 4 - Programming Project (Video Poker)
File: readMe.txt
written by William J. Reid
UNI: wjr2118
Date: June 22, 2016

A. Explanation of what I did and reasons for designing the code the way I did:

Following the templates provided, a Game Class, Deck Class, Player Class, and Card Class were created following the criteria shown below, as outlined by Dr. Cannon:

Your program must use the attached templates. These templates are for the classes: Card,Deck, Game, Player, and a test class, PokerTest.  You will need to fill-in the existing methods and most likely add more methods and/or instance variables to all of these classes except for the test class PokerTest. PokerTest must remain exactly as it is here. This project requires you to have two versions of your game each constructed using a different version of the Game constructor. One will require an explicit parameter that you will get as a command-line argument, this is to help you (and us) test your code. That is, it will allow the user to specify the hand that the player gets which will help in testing if your game correctly identifies the various hands.


Rules Used:

1. The suit ranking used in the game of bridge is (ascending alphabetical order):
clubs is lowest suit, followed by diamonds, hearts, and lastly spades (the highest suit).
2. We were instructed to code the suits in following way: "use integers 1-4 to encode the suit"

3. Pertains to the Game Class
      Make a hand for the player using the following encoding for cards:
	 c = clubs, d = diamonds, h = hearts, s = spades
	 1-13 correspond to ace - king
	 example: s1 = ace of spades
	 example: testhand = {s1, s13, s12, s11, s10} = royal flush


Strategies used:

Card Class
1. We first compare the value of the card (i.e., Ace, 1, 2, 3,...,King)
By subtracting the value, we will know if the cards have the same value if and only if their difference is equal to 0.

2. We will know whether the card passed in is greater in value if the difference is a positive integer.

3. And we will know the the card passed in is smaller in value if the difference is a negative integer.
NOTE: These were a stepping stone to create the Game Class. First the Card and Deck classes were created, then the Player class, and lastly the Game class. 


Game class
4. The reason for starting with the best possible hand  in the if-statement (line 166) (and all the others in the else if -statement) is so that only the highest possible rank is returned, as often times in Poker a higher hand contains one or more of the other possible hands (for example, a full house consists of a pair and a three of a kind.) If the "pair" block or "three of a kind" block were to come before the "full house" block, the player would be told that he/she has a pair, a three of a kind, or both (in addition to a full house).

5. We must think of the methods that rank the hand as checkpoints, starting at the lowest possible hand (a pair) and moving on to the highest. Thinking of them as checkpoints allows us to use the value that a specific method returns to check whether a different (higher) rank is possible or not. For example:

	Three of a kind: Contains (pair)
	Full House: Contains (pair + three of a kind)
	Four of a kind: Contains (pair + pair, but it also contains a three of a kind)
	etc...


B. Instructions for using software:
Compile the file named “PokerTest.java” by typing “javac PokerTest.java” in the Terminal. This is the main method. Then, run the PokerTest file from the terminal by typing “java PokerTest”. 

