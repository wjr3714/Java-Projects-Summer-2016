/**
*****************************************************
  This is the Oracle class for the Bulls and Cows program.
  Template provided by Dr. Cannon

  COMSS 1004 JAVA - Homework 3: Programming Project
  written William J. Reid
  UNI: wjr2118
  Date: June 9, 2016
******************************************************
*/

// The Oracle class should store the actual computer choice as a String and have methods to determine how many bulls and cows any given guess would generate.
public class Oracle{

    private String pattern; /** The Oracle class should store the actual computer choice as a String and
    have methods to determine how many bulls and cows any given guess would generate. */
    public int totalCows;  // Initiates the variable that will be used to count the total number of cows.
    public int totalBulls; // Initiates the variable that will be used to count the total number of bulls.


    public Oracle(){
    // your code here for setting up an Oracle object.
      totalCows = 0;  /** Sets the counter for the amount of cows to zero.
                          This value will be updated in the "howManyCows" method (
                          below) if cows are indeed present. */
      totalBulls = 0; /** Sets the counter for the amount of bulls to zero.
                          This value will be updated in the "howManyBulls" method
                          (below) if bulls are indeed present. */
    }


    public void setPattern(String solution){
    // This method is complete. Don't touch it.
    // This method is here to allow us and you
    // to test your code. You should only use
    // this method to help you test your code
    // while you are developing your program.

        pattern = solution;
    }

    public String getPattern(){
    // This method is complete. Don't touch it.
    // This method is here to allow us and you
    // to test your code. You should only use
    // this method to help you test your code
    // while you are developing your program.

        return pattern;
    }

    public int howManyBulls(String guess){
    // Determines the number of bulls the String guess should earn.
      totalBulls = 0; // The counter for bulls is set to zero as the counting has not yet started.
      for(int i = 0; i < 4; i++) {
        if(pattern.charAt(i) == guess.charAt(i)) {  // checks whether the characters at each index are equal.
          totalBulls++; // if the characters are at a given index are equal, we tally a bull.
        }
      }
      return totalBulls;
    } // End of the howManyBulls() method.


    // Determines the number of cows the String guess should earn
    public int howManyCows(String guess){

    /** A few bugs still present in this method:
        1. When repeated digits are entered by the user, some times output is as expected, 
           but other times the cows are double counted.
        2. If a digit is placed at the right index (bull location) and the digit
           exists also at a different index (the cow shouldn't be counted as the
           bulls have precedence over the cows). At the moment, this only outputs the
           expected result when the bull is located at the last index of the string
           or when a repeat exists but the bull comes before the cow.
        */
      totalCows = 0; // The counter for cows is set to zero as the counting has not yet started.

      // Nested for loops are responsible for keeping track of the cows.
      // This is the part of the code that still doesn't work to perfection, as explained
      // in the comments above.
      for (int i = 0; i < 4; i++){
        for (int j = 0; j < 4; j++){
          if((i == 0) && (guess.charAt(i) != guess.charAt(i+1)) && (guess.charAt(i) != guess.charAt(i+2)) && (guess.charAt(i) != guess.charAt(i+3))){
            if((guess.charAt(i) == pattern.charAt(j)) && (guess.charAt(i) != pattern.charAt(i))){ //
              totalCows++;
            }
          }
          if((i == 1) && (guess.charAt(i) != guess.charAt(i+1) && (guess.charAt(i) != guess.charAt(i+2))) && (guess.charAt(i) != guess.charAt(i-1))){
            if((guess.charAt(i) == pattern.charAt(j)) && (guess.charAt(i) != pattern.charAt(i))){
                totalCows++;
              }
          }
          if(((i == 2)) && (guess.charAt(i) != guess.charAt(i+1)) && (guess.charAt(i) != guess.charAt(i-1)) && (guess.charAt(i) != guess.charAt(i-2)) ){
            if((guess.charAt(i) == pattern.charAt(j)) && (guess.charAt(i) != pattern.charAt(i))){ //
              totalCows++;
            }
          }
          if((i == 3) && (guess.charAt(i) == pattern.charAt(j)) && (guess.charAt(i) != pattern.charAt(i))){ //
              totalCows++;
          }
        }
      }
      return totalCows;
    }

// The Method "generateMysteryNumber" generates the random four digit number that the player will try to decipher.
public void generateMysteryNumber(int turns) {
  /** The number of turns is passed into this method to prevent a new 4 digit random number from
  being created every time the user guesses the wrong mystery number.*/

  String mysteryNumber = "";  // creates empty string to have digits concatenated to.
  int lowerBound = 0; // (inclusive) ---> Used to create the random numbers
  int upperBound = 10; // (exlusive) ---> Used to create the random numbers

    boolean flag = true;  // This is used to enter the while loop where random numbers will be created.

    // Create the variables that will hold each random digit created.
    int randomDigit1 = 0;
    int randomDigit2 = 0;
    int randomDigit3 = 0;
    int randomDigit4 = 0;

    while ((flag == true) && (turns == 0)){
      /** This notation (below) for random numbers creates a random digit between
      0 and 9 (inclusive) and stores it in a variable. */
      randomDigit1 = (int) (Math.random() * (upperBound - lowerBound)) + lowerBound;
      randomDigit2 = (int) (Math.random() * (upperBound - lowerBound)) + lowerBound;

      while((randomDigit1 == randomDigit2) && (mysteryNumber.length() < 3)){
          randomDigit2 = (int) (Math.random() * (upperBound - lowerBound)) + lowerBound;
          // Make sure that the two digits are not the same before creating the third random digit.
          if (randomDigit1 != randomDigit2){
            randomDigit3 = (int) (Math.random() * (upperBound - lowerBound)) + lowerBound;
          }
      }
      while(((randomDigit3 == randomDigit2) || (randomDigit3 == randomDigit1)) && (mysteryNumber.length() < 4)){
          randomDigit3 = (int) (Math.random() * (upperBound - lowerBound)) + lowerBound;
          // Make sure that the three digits are not the same before creating the fourth random digit
          if ((randomDigit3 != randomDigit2) && (randomDigit3 != randomDigit1)){
            randomDigit4 = (int) (Math.random() * (upperBound - lowerBound)) + lowerBound;
          }
      }
      while(((randomDigit4 == randomDigit3) || (randomDigit4 == randomDigit2) || (randomDigit4 == randomDigit1)) && (mysteryNumber.length() < 5)){
          randomDigit4 = (int) (Math.random() * (upperBound - lowerBound)) + lowerBound;
          // Make sure that the four digits are not the same before storing it as the mystery number!
          if ((randomDigit4 != randomDigit3) && (randomDigit4 != randomDigit2) && (randomDigit4 != randomDigit1)){
            /** Convert the integer to a string (using the method: "Integer.toString()") in 
            order to concatenate the four individual digits. */
            mysteryNumber = Integer.toString(randomDigit1) + Integer.toString(randomDigit2) + Integer.toString(randomDigit3) + Integer.toString(randomDigit4);
            pattern = mysteryNumber;  // Pattern was used as it was part of the template provided.
            // System.out.println(pattern); ---> Used for debugging purposes only.
            flag = false; // Exits the main while loop.

          }
       }
    }

     // System.out.println("The mystery number is: " + pattern);  //---> Used for debugging purposes only.

  }  // End of the method generateMysteryNumber().
}  // End of Oracle class.
