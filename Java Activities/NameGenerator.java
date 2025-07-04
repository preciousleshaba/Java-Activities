import java.util.Scanner;

public class NameGenerator {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

//Asking user for full name and process input
System.out.print("Enter your full name (e.g., Alice Johnson): ");
String fullName = scanner.nextLine().trim().toLowerCase(); // Trim spaces and convert to lowercase

//Split the full name into first and last names
String[] nameParts = fullName.split(" ");
String firstName = nameParts[0];
String lastName = nameParts[1];

//Capitalize the first letter of each name
firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);

//Reverse the last name
StringBuilder reversedLastName = new StringBuilder(lastName).reverse();

//Create the secret code name
String codeName = firstName.substring(0, 2) + reversedLastName;

//Add special ending
if (codeName.toLowerCase().contains("x") || isVowel(codeName.charAt(codeName.length() - 1))) {

// Append "X-Agent" if contains 'x' or ends with a vowel
codeName = new StringBuilder(codeName).append("X-Agent").toString();
} else {
// Insert "-007" in the middle
int middle = codeName.length() / 2;
codeName = new StringBuilder(codeName).insert(middle, "-007").toString();
}

//Display the final output
System.out.println(String.format("Your secret code name is: %s", codeName));
}

// Helper method to check if a character is a vowel
private static boolean isVowel(char c) {
return "aeiouAEIOU".indexOf(c) != -1;
}
}
