import java.util.Scanner;

public class StepsGame {
public static void main(String[] args) {

// Create a Scanner object to read user input
Scanner scanner = new Scanner(System.in);

// Ask the user to enter their name
System.out.print("Enter your name: ");
String name = scanner.nextLine();  // Read the whole line

// Check if the name is empty
if (name.isEmpty()) {
System.out.println("Name cannot be empty!");
return;  // Stop the program if no name is entered
}

// Greet the user with their name
System.out.println("Hello " + name + "!");

// Show number of characters in the name
System.out.println("Number of characters: " + name.length());

// Show first and last characters of the name
System.out.println("First character: " + name.charAt(0));
System.out.println("Last character: " + name.charAt(name.length() - 1));

// Check if the name contains letter 'a' or 'A'
if (name.toLowerCase().contains("a")) {
System.out.println("Your name contains the letter 'a' or 'A'.");
} else {
System.out.println("Your name does not contain the letter 'a' or 'A'.");
}

// Replace all vowels in the name with '*'
// (?i) makes the regex case-insensitive
String replaced = name.replaceAll("(?i)[aeiou]", "*");
System.out.println("Name with vowels replaced: " + replaced);

// Print parts of the name from the first letter up to each position
for (int i = 1; i <= name.length(); i++) {
 System.out.println(name.substring(0, i));
}

// Counting loop with special rules:
// Skip printing when i is 3, stop when i is 5
for (int i = 1; i <= name.length(); i++) {
if (i == 3) {
continue;  // Skip the rest of this loop when i=3
}
if (i == 5) {
break;  // Stop the loop when i=5
}
System.out.println("Counting: " + i);
}

// Ask the user for a second word
System.out.print("Enter a second word: ");
String secondWord = scanner.nextLine();

// Check if the two words are exactly the same
if (name.equals(secondWord)) {
System.out.println("The words are the same");
} else {
System.out.println("The words are not the same");
}

// Join the two words together and display the result
String joined = name.concat(secondWord);
System.out.println("Joined words: " + joined);

// Close the scanner to free resources
scanner.close();
}
}

