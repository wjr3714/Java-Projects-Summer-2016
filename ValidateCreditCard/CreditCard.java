/** 
***************************************************************	
	A CreditCard class

    COMSS 1004 JAVA - Homework 2: Programming Project
    written by William J. Reid
    UNI: wjr2118
    Date: June 1, 2016
***************************************************************
*/

/** This class assumes that the input from the user is a 12 digit number without spaces, dashes, etc.
    In other words, input from the user must be in the form ############ .
    Valid card numbers according to this set of rules include 4807-6052-1766 and 4094-3460-2754. 
    You should use these for testing out your program. */

public class CreditCard{
   // Start of instance variables
   private String numberOnCreditCard;  // The credit card number input by the user will be represented as a String.
   private boolean creditCardIsValid;  // Will be true if the credit card number is passes all the tests, and false otherwise.
   private int errorCode; // There are 6 different types of error codes.
   // End of instance variables

   // Start of:  Constructor implementation
	public CreditCard(String number){   // The constructor takes in one parameter, namely: the credit card number.
       numberOnCreditCard = number; // Passes the user's input into the previously created instance variable.
       creditCardIsValid = true;   // Strategy used: Assume the Credit Card Number provided by user is valid until proven otherwise.
       errorCode = 0;     /** In the check() method, the value  of the errorCode variable
                          will be changed to an integer between one and six dependent
                          upon the first test that the Credit Card object fails to pass. */
   }
   // End of:  Constructor implementation

   // Implementation of the Method: "check()"
	public void check(){  /** This is a mutator method that determines whether
                             the credit card number is valid or not. */

       // Verify (1): The first digit on the credit card is a "4".
		if(numberOnCreditCard.charAt(0) != '4'){  // The ".charAt()" method returns the character located at the specified index (in this case, the first index).
        	creditCardIsValid = false;           // We then check whether the character is a "4".
        	errorCode = 1;           // If it's anything other than a four, the Credit Card object is not valid.
        	return;                  /** Note on the '4' in the boolean expression:
                                    Single quotes ('') were used around the '4' because double quotes ("")
                                    is reserved for the type string. Single quotes on the other hand, is for
                                    elements of the type character */
       }
       // End of Verify (1).

        // Verify (2): The fourth digit is one greater than the fifth digit.
		if(Integer.parseInt(numberOnCreditCard.substring(3, 4)) != Integer.parseInt(numberOnCreditCard.substring(4, 5)) + 1){
         /** The method "Integer.parseInt()" converts a string into an integer.
             This allows the addition operation (as well as the integer integer comparison)
             within the boolean expression of the if-statement above. */
         /** Syntax for the ".substring()" method: substring(int beginIndex, int endIndex), where the "endIndex" is not inclusive.
             The ".substring()" method returns a new string that is a substring of the string being accessed. */
           creditCardIsValid = false;
           errorCode = 2;
           return;
		}
       // End of Verify (2).

       // Verify (3): The product of the first, fifth, and ninth digits must be 24.
		if(Integer.parseInt(numberOnCreditCard.substring(0, 1)) * Integer.parseInt(numberOnCreditCard.substring(4, 5)) * Integer.parseInt(numberOnCreditCard.substring(8, 9)) != 24){
            /** Use the ".substring()" method to get first, fifth, and ninth digits
                Convert each of the accessed strings into an integer using the "Integer.parseInt()" method, and then
                multiply the three digits accessed and check that their product equals 24. */
        	creditCardIsValid = false;
        	errorCode = 3;
			return;
		}
       // End of Verify (3).

       // Verify (4): The sum of all digits must be evenly divisible by 4.
		int sumDigits = 0;
		for(int i = 0; i < numberOnCreditCard.length(); i++){  // Iterate through all the characters in the Credit Card
			sumDigits = sumDigits + Character.getNumericValue(numberOnCreditCard.charAt(i));
		}
         // The method "Character.getNumericValue()" returns the integer value that the specified Unicode character represents.
         // Add the digit accessed to the rolling sum of the other digits until all digits have been added exactly once.

		if(sumDigits % 4 != 0){  // This if-statement is called only when the sum
			creditCardIsValid = false;  //of all digits is not evenly divisible by 4, that is,
			errorCode = 4;    // when the remainder (referring to the modulos symbol: "%") is not equal to zero.
			return;
		}
       // End of Verify (4).


       // Verify (5): The sum of the first four digits must be one less than the sum of the last four digits.
		int firstFourDigitsSum = 0;
		int lastFourDigitsSum = 0;

       /** Iterate through the first four digits of the Credit Card Number
        and add the four first digits together. */
		for(int i = 0; i < 4; i++){
			firstFourDigitsSum = firstFourDigitsSum + Character.getNumericValue(numberOnCreditCard.charAt(i));
		}

       /** Iterate through the last four digits of the Credit Card Number
        and add the last four digits together. */
		for(int i = 0, j = numberOnCreditCard.length() - 1; i < 4; i++, j--){
			lastFourDigitsSum = lastFourDigitsSum + Character.getNumericValue(numberOnCreditCard.charAt(j));
		}
       // Advanced FOR LOOP syntax: for( Parameter 1 ; Parameter 2 ; Parameter 3){BODY statements}
       /** Parameter 1: Instantiate variables (separate multiple variables with a comma ',')
           Parameter 1 (Continued): Executes only once during the beginning of loop. */
       /** Parameter 2: Boolean condition that must be met (condition gets evaluated each time the loop iterates).
           Parameter 2 (Continued): Loop executes the block of statement repeatedly until this condition returns false. */
       /** Parameter 3: Increment (i=i+1 or i++) or decrement (j=j-1 or j--) the variables initialized in the for loop.
           Parameter 3 (Continued): This parameter executes after each iteration of the loop. */
       /** Additional Note: Separate different parameters with semicolons (";"), but separate multiple
           declarations of the same parameter with commas (","). */

		if(firstFourDigitsSum != lastFourDigitsSum - 1){ // This is called only when
			creditCardIsValid = false; // the sum of the first four digits is not equal to
			errorCode = 5;             // one less than the sum of the last four digits.
			return;
		}
       // End of Verify (5).


       /** Verify (6): If you treat the first two digits as a two-digit number,
       and the seventh and eight digits as a two digit number, their sum must be equal to 100. */
		if(Integer.parseInt(numberOnCreditCard.substring(0, 2)) + Integer.parseInt(numberOnCreditCard.substring(6, 8)) != 100){
			creditCardIsValid = false;  // For the ".substring(0, 2)" & ".substring(6, 8)" methods, the second
			errorCode = 6;  // parameter inside the parenthesis is not inclusive.
			return;
        /** In the if-statement above, the "substring()" method is used to concatenate the first
        two digits as a two-digit number, and the seventh and eight digits as a two digit number.
        These are then converted into the integer type for the mathematical operation to be possible. */

		} // End of Verify (6).

	} // Here ends the method "check()".
      /** Note: The "check()" method should change the variable "errorCode" to the number
      corresponding to the first test that the credit card number did not pass.
      If no test was failed, then the variable errorCode remains with a value of zero. */

   // Method implementation for "isValid()"
	public boolean isValid(){  // This is an accessor method.
		return creditCardIsValid; // Returns true if all tests were passed and false otherwise. 
	} // Here ends the "isValid()" method

   // Method implementation for "getErrorCode()"
	public int getErrorCode(){ // This is an accessor method.
		return errorCode;  // returns the error to the user.
	} // Here ends the "getErrorCode()" method
	
} // Here ends the CreditCard class!
