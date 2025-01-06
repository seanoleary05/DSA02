import java.util.List;
import java.util.Scanner;

public class HelloController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomHash ch = new CustomHash(60);

        // Sample data
        ch.add(new Drink("Coke", "Classic soda drink", "USA", "image.com"), 12345);
        ch.add(new Drink("Pepsi", "Popular soda drink", "USA", "image2.com"), 54321);
        ch.add(new Ingredient("Barley", "Main ingredient for beer", 5.0f), 11223);
        ch.add(new Ingredient("Hops", "Adds bitterness to beer", 0.0f), 44556);

        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Print Entire Hashtable");
            System.out.println("2. Add a new Drink");
            System.out.println("3. Add a new Ingredient");
            System.out.println("4. Search Drinks by Name");
            System.out.println("5. Search Drinks by Location");
            System.out.println("6. Search Ingredients by Name");
            System.out.println("7. Search Ingredients by ABV Range");
            System.out.println("8. Delete an Item");
            System.out.println("9. Update/Edit an Item");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    for (int i = 0; i < ch.hashTable.length; i++) {
                        if (ch.hashTable[i] != null) {
                            System.out.println(i + ". " + ch.hashTable[i]);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter Drink Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter Image URL: ");
                    String url = scanner.nextLine();

                    int hashCode = name.length() * 7 + description.length() * 13;
                    ch.add(new Drink(name, description, location, url), hashCode);
                    System.out.println("Drink added.");
                    break;

                case 3:
                    System.out.print("Enter Ingredient Name: ");
                    String iName = scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String iDescription = scanner.nextLine();
                    System.out.print("Enter ABV: ");
                    float ABV = scanner.nextFloat();
                    scanner.nextLine();

                    int iHashCode = iName.length() * 7 + iDescription.length() * 13;
                    ch.add(new Ingredient(iName, iDescription, ABV), iHashCode);
                    System.out.println("Ingredient added.");
                    break;

                case 8:
                    System.out.print("Enter the item to delete (Drink or Ingredient name): ");
                    String deleteName = scanner.nextLine();
                    boolean deleted = ch.delete(deleteName);
                    System.out.println(deleted ? "Item deleted successfully." : "Item not found.");
                    break;

                case 9:
                    System.out.print("Enter the name of the item to update: ");
                    String updateName = scanner.nextLine();

                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();
                    System.out.print("Enter new location or ABV: ");
                    String newField = scanner.nextLine();

                    // Assume you're handling Drinks and updating its description.
                    Drink oldDrink = new Drink(updateName, "", "", "");
                    Drink newDrink = new Drink(updateName, newDescription, newField, "");
                    boolean updated = ch.update(oldDrink, newDrink);

                    System.out.println(updated ? "Item updated successfully." : "Item not found.");
                    break;

                case 10:
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
