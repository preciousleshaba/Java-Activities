import java.util.Scanner;

public class StudentGrader {

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
boolean retry = true;

while (retry) {
// Ask user to enter exam score
System.out.print("Enter your exam score: ");
int score = scanner.nextInt();
scanner.nextLine();  // consume leftover newline

// Add 5 bonus points
score += 5;

// Subtract 2 points penalty if original score (before bonus) was below 40
if (score - 5 < 40) {  // score - 5 to get original score
score -= 2;
}

// Determine pass/fail and status
boolean pass = score >= 80;
String status = pass ? "Excellent" : (score >= 60 ? "Good" : "Need Improvement");

// Show results
System.out.println("Result: " + (pass ? "Pass" : "Fail"));
System.out.println("Score: " + score + " - " + status);

// Check the last digit of score and print a message
int lastDigit = score % 10;
switch (lastDigit) {
case 0:
case 5:
System.out.println("Nice round number!");
break;

case 1:
case 2:
case 3:
case 4:
System.out.println("Low tail");
break;

case 6:
case 7:
case 8:
case 9:
System.out.println("High tail");
break;

default:
System.out.println("Interesting score");
break;
}

// Ask user if they want to try again
System.out.print("Would you like to try again? (yes/no): ");
String answer = scanner.nextLine().toLowerCase();

// Validate input and loop until valid answer given
while (!answer.equals("yes") && !answer.equals("no")) {
System.out.print("Invalid input. Please type 'yes' or 'no': ");
answer = scanner.nextLine().toLowerCase();
}

if (answer.equals("no")) {
retry = false;  // exit the loop
System.out.println("Goodbye!");
}
}

scanner.close();  // close scanner
}
}


 




