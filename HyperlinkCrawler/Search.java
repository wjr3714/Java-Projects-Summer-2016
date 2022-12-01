/**
 *****************************************************
 Programming Project (Question 1): Word Search

 COMSS 1004 JAVA - Homework 5: Programming Project
 written William J. Reid
 UNI: wjr2118
 Date: June 24, 2016
 ******************************************************
 

Write an application called Search in Java that searches a file specified on the command
line and prints out all lines containing a keyword and the number of times the keyword
appears in the file. So for example for:

        java Search walk Example.txt

The output may be:

    He likes long walks on the beach.
    Nobody walks in Los Angeles
    Why don't you walk like me instead of walking like that.
    Total number of occurrences: 4

---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
Use program by typing the command line the following: java Search [WordToSearch] [FileName]

Resources Used:
pgs. 519-529 & pg. 543 of Big Java: Early Objects by Cay Horstmann
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
*/


import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Search{

	private static Scanner inputFile;

	public static void main(String[] args) throws FileNotFoundException{

		if (args.length < 2){
			softwareUsage();
			throw new IllegalArgumentException("\n\nNot enough arguments provided!\n");
		}
		else{
			try{
				try{
					String wordToSearch = args[0];

					if (wordToSearch.contains(".") == true){ // Checks whether the first argument is the word to search.
						softwareUsage();
						System.exit(0);   // Terminates the entire program.
						 // Assumption: No word in the English language has a period, the input file will have one though as part of its extension.
					} // This if statement will terminate the code and tell the user the correct format to use the program.
					// get the file names one by one from the command line arguments

					int wordOccurence = 0; // Counts the number of occurrences of the specified word.

					inputFile = new Scanner(new	File(args[1])); // Get the name of the file to search the word in.

					System.out.println("\n************************************************************************\n");
					System.out.println("The lines that contain the word " + "'" + wordToSearch + "'" + " in the file " + "'" + args[1] + "'" +" are:\n");
					while(inputFile.hasNextLine()){

						String line = inputFile.nextLine();

						// Search the text file word for word in each line. The prorgram is case insensitive.

						if (line.contains(wordToSearch)){
							wordOccurence++;
							System.out.println("\n"+line+"\n"); // Print the entire line containing the specified word.
							System.out.println("_________________________________________________________________________");
						}
					} // End of while loop.

					if (wordOccurence == 0){ // If no wordmatch was found, tell the user.
						System.out.println("The file " + "'" + args[1] + "'" +" does not contain any instances of the word " + "'" + wordToSearch + "'.");
					}
					else{ // Print the number of occurences that the search word appeared in the input file.
						System.out.println("\nNumber of occurrences of the word " + "'" + wordToSearch + "'" + " is: " + wordOccurence + ".\n");
						System.out.println("\n************************************************************************\n");
					}
				} // End of inner try{}

				finally{
					inputFile.close(); // Force the program to close the file if an exception is found by using the reserved word "finally"
				}
			}
			catch (FileNotFoundException exception){
				System.out.println("\nFile specified is not in the current directory.\n");
			}
		}
	}

	public static void softwareUsage(){ // Remind the user the order of the command line arguments
		System.out.println("\nImproper usage of software. \nInput in the command line should be in the form: \n");
		System.out.println("\tjava Search [WordToSearch] [FileName] \n");
	}
}
