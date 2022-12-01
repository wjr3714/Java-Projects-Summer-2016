/**
 *****************************************************
 Programming Project (Question 2): URL Finder

 COMSS 1004 JAVA - Homework 5: Programming Project
 written William J. Reid
 UNI: wjr2118
 Date: June 25, 2016
 ******************************************************


Proejct Instructions:
 Write a static method in Java that takes a website’s URL as an explicit parameter
 (represented as a String) and returns an ArrayList of all of the hyperlinks of the form

      <a href=“link”>link text</a>

 on the website (represented as Strings). So we can automatically test your work,
 your method must have the following signature:

      public static ArrayList<String> getLinks(String location)

 You must put your method in a file called Links.java

*/


import java.util.Scanner;
import java.util.ArrayList;
import java.net.URL;

public class Links{

    public static ArrayList<String> getLinks(String location){ // Write a static method in Java
        //that takes a website’s URL as an explicit parameter (represented as a String)

        ArrayList<String> urlList = new ArrayList<>(); // This is the ArrayList to which we will
        // append the URLs we find in the website in order of appearance.

        try{
        URL urlAddress = new URL(location); // Creates a URL object (in this case, are starting or first url)
        Scanner input = new Scanner(urlAddress.openStream()); // Opens a connection to the URL and returns an InputStream for reading from that connection.
        int isURLAddress = 0; // Will be used for indexing and finding location of URL in line.

        while (input.hasNext()){ // While the webpage has content in it
            String line = input.nextLine(); // Read each line of the website.
            isURLAddress = line.indexOf("href=", isURLAddress);  // Search for a URL using the keyword "href="
            // "indexOf()" returns the index within this string of the first occurrence of
            //the specified substring. If it does not occur as a substring, -1 is returned.

            while (isURLAddress > 0){
                int lastCharacterOfURL = line.indexOf("\"", isURLAddress); // The URL ends with a quote provided the format: <a href=“link”>link text</a>

                if (lastCharacterOfURL > 0){
                    // Retrieve the URL and then continue looking for other URLs
                    urlList.add(line.substring(isURLAddress, lastCharacterOfURL)); // Add the URL (ONLY) to the ArrayList of URLs
                    isURLAddress = line.indexOf("http:", lastCharacterOfURL);
                }
                else{
                    continue;
                }
            }
        }
    }
    catch (Exception error) {
        System.out.println("Error found: " + error.getMessage());
    }

        return urlList; // returns an ArrayList of all of the hyperlinks of the form: <a href=“link”>link text</a>
    }
}
