
Homework 2 - Programming Project (Credit Card)
File: readMe.txt
written by William J. Reid
UNI: wjr2118
Date: June 5, 2016


A. Explanation of what I did and reasons for designing the code the way I did:

In order to create an algorithm that can validate a credit card number, I created a CreditCard class that represents a card number as a String and created an instance variable of type String to store this. Reason for storing the credit card number as a string rather than an integer: there are various methods of the String class that can be used to accessed the individual digits in the string. The “Integer.parseInt()” method (and similarly the “Character.getNumericValue()” method) can be used to convert the string into an integer when a mathematical operation is required to check the validity of the credit card number. 
A mutator method called “check()” was created to determine if the credit card number is valid or not. Six different boolean expressions were created to test each of the criteria that the credit number must pass to be determined a valid credit card number, namely: 

    1. The first digit must be a 4.
    2. The fourth digit must be one greater than the fifth digit
    3. The product of the first, fifth, and ninth digits must be 24
    4. The sum of all digits must be evenly divisible by 4
    5. The sum of the first four digits must be one less than the sum of the last four digits
    6. If you treat the first two digits as a two-digit number, and the seventh and eight digits as a two digit number, their sum must be 100.

For each boolean expression in the “check()” method, if the test was not passed, a variable named “errorCode” would be changed to the integer (between 1 and 6) of the test that was not passed, and the integer would then be output to the user indicating the error. The error code would then be accessed by an accessor method called “getErrorCode()” that would return the value of the variable errorCode. The first error that was found would then be returned to the user. If no tests were failed, then the variable errorCode would have a value of zero and the program would tell the user that the credit card number is valid. 

Note: The valid card numbers (4807-6052-1766 and 4094-3460-2754) provided by Dr. Cannon were both used to test the program. 

B. Instructions for using your software:
Compile the file named “CreditCard.java” by typing “javac CreditCard.java” in the Terminal. In addition, compile the file “CreditCardTester.java” written by Dr. Cannon which contains the main method for the CreditCard class. Then, run the CreditCardTester file from the terminal by typing “CreditCardTester”. The program was coded assuming that the user would enter a 12 digit number without spaces, dashes, etc. In other words, input from the user must be in the form ############ .


C. Who did you discussed the problem with: 

I discussed the problem with no one, but the following Java documentation sources were particularly useful in troubleshooting the errors of my CreditCard class. The sources used are listed below:

1. ".substring()" Method: http://www.tutorialspoint.com/java/java_string_substring.htm
2. ".charAt()" Method: http://www.tutorialspoint.com/java/java_string_charat.htm
3. "Integer.parseInt()" Method: http://www.tutorialspoint.com/java/number_parseint.htm
4. "Character.getNumericValue()" Method: http://www.tutorialspoint.com/java/lang/character_getnumericvalue.htm
5. Java API - Class Integer: https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html
6. Java API - Class String: https://docs.oracle.com/javase/7/docs/api/index.html?java/lang/String.html
7. Java API - Class Character: https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
8. Returning a Value from a Method: https://docs.oracle.com/javase/tutorial/java/javaOO/returnvalue.html
9. Help with For Loops: pages 258-261 of Cay Horstmann’s Textbook “Big Java: Early Objects - 5th Edition”. 
