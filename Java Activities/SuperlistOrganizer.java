import java.util.*;

public class SuperlistOrganizer {

// This method adds multiple tasks under a given category
public static void addTasks(Map<String, List<String>> superlist, String category, String... tasks) {
// Make sure the category starts with a capital letter
category = capitalize(category);

// Check if category already exists, if not, create it
if (!superlist.containsKey(category)) {
superlist.put(category, new ArrayList<>());
}

// Get the list of tasks for the category
List<String> taskList = superlist.get(category);

// Add each task to the list
for (String task : tasks) {
task = capitalize(task.trim()); // Clean up and format
if (!taskList.contains(task)) { // Avoid duplicates
taskList.add(task);
}
}

// Sort the tasks alphabetically
Collections.sort(taskList);
}

// This method capitalizes the first letter of a word
public static String capitalize(String word) {
if (word == null || word.isEmpty()) return word;
return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
}

public static void main(String[] args) {
// Create a scanner to read user input
Scanner scanner = new Scanner(System.in);

// This map will store category -> list of tasks
Map<String, List<String>> superlist = new LinkedHashMap<>();

System.out.println("Welcome to the Superlist Organizer!");
        
// Repeat until the user types "done"
while (true) {
System.out.print("Enter category name (or type 'done'): ");
String category = scanner.nextLine().trim();

if (category.equalsIgnoreCase("done")) {
break;
}

System.out.print("Enter tasks (comma-separated): ");
String taskInput = scanner.nextLine();
String[] tasks = taskInput.split(",");

// Add tasks to the superlist
addTasks(superlist, category, tasks);
}

// Show all categories and tasks
System.out.println("\nYour Superlist:");
for (String cat : superlist.keySet()) {
System.out.println("Category: " + cat);
for (String task : superlist.get(cat)) {
System.out.println("- " + task);
}
}

// Allow the user to delete tasks if needed
System.out.print("\nDo you want to delete any tasks? (yes/no): ");
String answer = scanner.nextLine();

while (answer.equalsIgnoreCase("yes")) {
System.out.print("Enter category to delete from: ");
String categoryToDelete = capitalize(scanner.nextLine());

if (superlist.containsKey(categoryToDelete)) {
System.out.print("Enter task to delete: ");
String taskToDelete = capitalize(scanner.nextLine());

List<String> tasks = superlist.get(categoryToDelete);
if (tasks.remove(taskToDelete)) {
System.out.println("Task removed!");

} else {
System.out.println("Task not found.");
}

// Remove the category if no tasks are left
if (tasks.isEmpty()) {
superlist.remove(categoryToDelete);
}

} else {
System.out.println("Category not found.");
}

System.out.print("Do you want to delete another task? (yes/no): ");
answer = scanner.nextLine();
}

// Final list after deletion
System.out.println("\nFinal Superlist:");
for (String cat : superlist.keySet()) {
System.out.println("Category: " + cat);
for (String task : superlist.get(cat)) {
System.out.println("- " + task);
}
}

System.out.println("Thank you for using Superlist Organizer!");

scanner.close();
}
}
