import java.util.Scanner;

public class WordAnalyzer {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

// Ask the user to enter a sentence
System.out.println("Enter a sentence:");
String sentence = scanner.nextLine().trim();

// Convert sentence to lowercase for uniform analysis
sentence = sentence.toLowerCase();

// Split sentence into words by spaces
String[] words = sentence.split(" ");

// Print all words
System.out.println("Words in the sentence:");
for (String word : words) {
System.out.println(word);
}

// Check if there is at least one word to analyze
if (words.length > 0) {
String firstWord = words[0];

// Print length of first word
System.out.println("Length of first word: " + firstWord.length());

// Find index of 'a' in first word
int index = firstWord.indexOf('a');
if (index != -1) {
System.out.println("Index of 'a' in first word: " + index);
} else {
System.out.println("'a' is not found in the first word.");
}

// Check if first word starts with 'j' and ends with 'g'
System.out.println("First word starts with 'j': " + firstWord.startsWith("j"));
System.out.println("First word ends with 'g': " + firstWord.endsWith("g"));

// Convert length of first word to string and print
String lengthStr = String.valueOf(firstWord.length());
System.out.println("Length as string: " + lengthStr);

// Ask user for a second word
System.out.println("Enter a second word:");
String secondWord = scanner.nextLine().trim();

// Compare second word with first word lexicographically
int compareResult = secondWord.compareTo(firstWord);

if (compareResult < 0) {
System.out.println("Second word comes before the first word alphabetically.");
} else if (compareResult > 0) {
System.out.println("Second word comes after the first word alphabetically.");
} else {
System.out.println("Both words are the same.");
}

// Using intern() to check if both strings refer to the same object in memory
String firstInterned = firstWord.intern();
String secondInterned = secondWord.intern();

System.out.println("Using intern(): " + (firstInterned == secondInterned));

// Using String.format to print a message
System.out.println(String.format("Thank you, %s!", secondWord));

// Print number of words in sentence
System.out.println("Number of words: " + words.length);

// Join words into a single string with spaces
String joinedWords = String.join(" ", words);
System.out.println("Joined words: " + joinedWords);

// Ask for a third word
System.out.println("Enter a third word:");
String thirdWord = scanner.nextLine().trim();

// Find alphabetically first word among the three
String alphabeticallyFirst = firstWord;

if (secondWord.compareTo(alphabeticallyFirst) < 0) {
alphabeticallyFirst = secondWord;
}

if (thirdWord.compareTo(alphabeticallyFirst) < 0) {
alphabeticallyFirst = thirdWord;
}

System.out.println("Alphabetically first word: " + alphabeticallyFirst);
} else {
System.out.println("No words entered.");
}

scanner.close();
}
}
