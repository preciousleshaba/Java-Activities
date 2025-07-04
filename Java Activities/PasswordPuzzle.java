import java.util.Arrays;
import java.util.Scanner;

public class PasswordPuzzle {

public static void main(String[] args) {

Scanner scanner = new Scanner(System.in); // Create a Scanner to get user input

// Asking the user how many words they want to enter (between 3 and 5)
System.out.print("How many words would you like to enter (3 to 5)? ");
int numWords = scanner.nextInt();
scanner.nextLine(); // This clears the newline left in the input

// Checking if the number is valid
if (numWords < 3 || numWords > 5) {
System.out.println("Invalid number of words. Please enter between 3 and 5.");
return; // Stop the program
}

// Create an array to store the words
String[] words = new String[numWords];

// Asking the user to enter each word
for (int i = 0; i < numWords; i++) {
System.out.print("Enter word " + (i + 1) + ": ");
words[i] = scanner.nextLine(); // Store the input word in the array
}

// Clean up each word: trim spaces, capitalize first letter, lowercase the rest
String[] cleanedWords = new String[numWords];
for (int i = 0; i < numWords; i++) {
String trimmed = words[i].trim(); // Remove leading/trailing spaces
cleanedWords[i] = trimmed.substring(0, 1).toUpperCase() + trimmed.substring(1).toLowerCase();
System.out.println((i + 1) + ". " + cleanedWords[i]); // Show cleaned word
}

// Ask the user to choose two numbers for password creation
System.out.print("Choose two word numbers to create your password (e.g., 1 and 3): ");
int num1 = scanner.nextInt();
int num2 = scanner.nextInt();
scanner.nextLine(); // Clear leftover newline

// Check if the numbers are within range
if (num1 < 1 || num1 > numWords || num2 < 1 || num2 > numWords) {
System.out.println("Invalid numbers chosen. Exiting.");
return;
}

// Create the password:
// - Reverse the first chosen word
// - Add a symbol "@"
// - Add first 3 letters of the second chosen word
// - Add the combined length of both words
String password = new StringBuilder(cleanedWords[num1 - 1]).reverse().toString()
                 + "@"
                 + cleanedWords[num2 - 1].substring(0, 3)
                 + (cleanedWords[num1 - 1].length() + cleanedWords[num2 - 1].length());

// Check if the password starts with a vowel
char firstChar = Character.toLowerCase(password.charAt(0));
if ("aeiou".indexOf(firstChar) >= 0) {
System.out.println("Your password starts with a vowel.");
}

// Show the final password
System.out.println("Your password is: " + password);

// Allow the user to try again in a loop
while (true) {
System.out.print("Would you like to try again? (yes/no): ");
String response = scanner.nextLine();

if (response.equalsIgnoreCase("yes")) {
// Let the user choose a special symbol
System.out.print("Enter a special symbol (@ or #): ");
String symbol = scanner.nextLine();

// Rebuild the password using the new symbol
password = new StringBuilder(cleanedWords[num1 - 1]).reverse().toString()
          + symbol
          + cleanedWords[num2 - 1].substring(0, 3)
          + (cleanedWords[num1 - 1].length() + cleanedWords[num2 - 1].length());

// Show the new password
System.out.println("Your new password is: " + password);
} else {
break; // Exit the loop if the user says no
}
}

// Sort the cleaned words in alphabetical order
Arrays.sort(cleanedWords);

// Print the sorted words
System.out.println("Sorted words:");
for (int i = 0; i < numWords; i++) {
System.out.println((i + 1) + ". " + cleanedWords[i]);
}

scanner.close(); // Always close the scanner
}
}
