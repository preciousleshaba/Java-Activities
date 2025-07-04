package Vehicle; // Creating a package called 'Vehicle'

import java.util.Scanner; // Importing the Scanner class to get user input

// Defining a class called Car
public class Car {

// Declaring private variables (data) that belong to each car
private String model;
private int year;
private double price;

// This block runs automatically every time an object is created
{
System.out.println("Initializing car...");
}

// A constructor that sets the values of model, year, and price
public Car(String model, int year, double price) {
this.model = model;  // Set the model of the car
this.year = year;    // Set the year of the car
this.price = price;  // Set the price of the car
}

// A method to show the details of the car
public void displayDetails() {
System.out.println("Car Model: " + model); // Print the model
System.out.println("Year: " + year);       // Print the year
System.out.println("Price: R" + price);    // Print the price with "R" for Rand
}

// The main method - this is where the program starts running
public static void main(String[] args) {

// Creating a Scanner object to get input from the user
Scanner scanner = new Scanner(System.in);

// Asking the user to enter the car's model
System.out.println("Enter car model:");
String model = scanner.nextLine();

// Asking the user to enter the car's year
System.out.println("Enter car year:");
int year = scanner.nextInt();

// Asking the user to enter the car's price
System.out.println("Enter car price:");
double price = scanner.nextDouble();

// Creating a new Car object with the information the user entered
Car myCar = new Car(model, year, price);

// Calling the method to display the car's details
myCar.displayDetails();

// Closing the scanner (good practice)
        scanner.close();
}
}
