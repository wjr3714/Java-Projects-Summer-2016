/**
*****************************************************
  This is the Game class for the Bulls and Cows program.
  Template provided by Dr. Cannon

  COMSS 1004 JAVA - Homework 3: Programming Project
  written William J. Reid
  UNI: wjr2118
  Date: June 9, 2016
******************************************************
*/

import java.util.Scanner;

public class Game{

    // Instance variables
    private int turns;
    private Oracle computer;
    private Scanner input;
    public int totalCows;
    public int totalBulls;


    // Code for the Game constructor
    public Game(){
      turns = 0;                      /** This is the counter for the number of turns that it takes the player to
                                          to decipher the secret number. */
      input = new Scanner(System.in); // For the player to enter his/her guess of the number.
      computer = new Oracle();        /** Creates the object "computer" of the Oracle class, which
                                          behaves as the host of the Bulls and Cows game. The "computer" will
                                          be responsible for creating the mystery number of 4 digits (where no repeats
                                          exist). The blue print for creating the mystery number can be found in the
                                          Oracle class, under the method "generateMysteryNumber()"
                                          */
    }


    public void playGame(){
    // your code for the Game playGame method goes here

      boolean flag = true; // Used to enter the while loop below.
      while (flag == true){
          playOneTurn(turns);
          turns++; //updates the number of guess attempts from the player.

          System.out.println("Please enter your four-digit (integer) guess: "); // Ask for player's input.

          String guess = input.next(); /** Saves the player's input as in a type string variable.
          The benefits of saving it as a string is to take advantage already build methods in the String class, such as
          charAt(), Integer.toString(), etc.  */

          int totalCows = computer.howManyCows(guess); /** Pass in the player's input
          into the method that will count the number of cows (found in Oracle class). */

          int totalBulls = computer.howManyBulls(guess); /** Pass in the player's
          input into the method that will count the number of bulls (found in the Oracle class). */

          if (totalBulls == 4){  /**  When the player correctly guesses the secret number,
            the number of bulls will be exactly 4. This is the only instance where the bulls
            will ever have a value of 4. */
            System.out.println(" ");
            System.out.println("**************************************** ");
            System.out.println(" ");
            System.out.println("\nNumber of cows: " + totalCows +".");
            System.out.println("Number of bulls: " + totalBulls + ".");
            System.out.println("\nYou found the solution in: " + turns + " attempts.");
            System.out.println("\nThank you for playing! See you soon!");
            System.out.println(" ");
            System.out.println("**************************************** ");
            System.out.println(" ");
            flag = false;  /** When the "flag" becomes false, it will prevent the first
            while loop in this method from running. */
          }

          /** The code in the else-statement below is called to give feedback to
          the player regarding the number of bulls and cows that occurred in his/her guess.
          If the number of bulls is not 4, the number of bulls and cows
          will be shown to player and the while loops will be called again (meaning
          that the player will be prompted to enter another guess. */
          else {
            System.out.println(" ");
            System.out.println("**************************************** ");
            System.out.println(" ");
            System.out.println("Try again!");
            System.out.println(" ");
            System.out.println("Number of cows: " + totalCows);
            System.out.println("Number of bulls: " + totalBulls + ".");
            System.out.println(" ");
            System.out.println("Your last guess was: " + guess + ".");
            System.out.println("Total number of attempts: " + turns + ".");
            System.out.println(" ");
            System.out.println("**************************************** ");

          }

      }
    } // Here ends the playGame() method.


    public void playOneTurn(int turns){
    // your code for the Game playOneTurn method goes here
        
      computer.generateMysteryNumber(turns); /** The "generateMysteryNumber" is a method 
      in the Oracle class that creates the random 4 digit number that the player has to guess. */
    }

    public void setPattern(String solution){
    // This method is complete. Don't touch it.
    // it is here to allow us and you to test your code.
    // You should only use this method to help you test
    // your code while developing.

        computer.setPattern(solution);
    }

    public String getPattern(){
    // This method is complete. Don't touch it.
    // This method is here to allow us and you
    // to test your code. You should only use
    // this method to help you test your code
    // while you are developing your program.

        return computer.getPattern();
    }
} // End of the Game() class.

// ----------------------------------------------------------------------
    // any other methods you may need go here
