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
            System.out.println("4. Delete a Drink");
            System.out.println("5. Delete an Ingredient");
            System.out.println("6. Update a Drink");
            System.out.println("7. Update an Ingredient");
            System.out.println("8. Search Drinks by Name");
            System.out.println("9. Search Ingredients by Name");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1: // Print Hashtable
                    for (int i = 0; i < ch.hashTable.length; i++) {
                        if (ch.hashTable[i] != null) {
                            System.out.println(i + ". " + ch.hashTable[i]);
                        }
                    }
                    break;

                case 2: // Add a Drink
                    System.out.print("Enter Drink Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter Image URL: ");
                    String url = scanner.nextLine();

                    int drinkHashCode = name.length() * 7 + description.length() * 13;
                    ch.add(new Drink(name, description, location, url), drinkHashCode);
                    System.out.println("Drink added.");
                    break;

                case 3: // Add an Ingredient
                    System.out.print("Enter Ingredient Name: ");
                    String iName = scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String iDescription = scanner.nextLine();
                    System.out.print("Enter ABV: ");
                    float ABV = scanner.nextFloat();
                    scanner.nextLine();

                    int ingredientHashCode = iName.length() * 7 + iDescription.length() * 13;
                    ch.add(new Ingredient(iName, iDescription, ABV), ingredientHashCode);
                    System.out.println("Ingredient added.");
                    break;

                case 4: // Delete a Drink
                    System.out.print("Enter the name of the drink to delete: ");
                    String drinkName = scanner.nextLine();
                    boolean drinkDeleted = ch.deleteDrinkByName(drinkName);
                    System.out.println(drinkDeleted ? "Drink deleted successfully." : "Drink not found.");
                    break;

                case 5: // Delete an Ingredient
                    System.out.print("Enter the name of the ingredient to delete: ");
                    String ingredientName = scanner.nextLine();
                    boolean ingredientDeleted = ch.deleteIngredientByName(ingredientName);
                    System.out.println(ingredientDeleted ? "Ingredient deleted successfully." : "Ingredient not found.");
                    break;

                case 6: // Update a Drink
                    System.out.print("Enter the name of the drink to update: ");
                    String drinkToUpdate = scanner.nextLine();
                    System.out.print("Enter new Description (or press Enter to skip): ");
                    String newDescription = scanner.nextLine();
                    System.out.print("Enter new Location (or press Enter to skip): ");
                    String newLocation = scanner.nextLine();
                    System.out.print("Enter new Image URL (or press Enter to skip): ");
                    String newImageUrl = scanner.nextLine();

                    boolean drinkUpdated = ch.updateDrinkByName(drinkToUpdate,
                            newDescription.isEmpty() ? null : newDescription,
                            newLocation.isEmpty() ? null : newLocation,
                            newImageUrl.isEmpty() ? null : newImageUrl);
                    System.out.println(drinkUpdated ? "Drink updated successfully." : "Drink not found.");
                    break;

                case 7: // Update an Ingredient
                    System.out.print("Enter the name of the ingredient to update: ");
                    String ingredientToUpdate = scanner.nextLine();
                    System.out.print("Enter new Description (or press Enter to skip): ");
                    String newIngredientDescription = scanner.nextLine();
                    System.out.print("Enter new ABV (or press -1 to skip): ");
                    float newABV = scanner.nextFloat();
                    scanner.nextLine();

                    boolean ingredientUpdated = ch.updateIngredientByName(ingredientToUpdate,
                            newIngredientDescription.isEmpty() ? null : newIngredientDescription,
                            newABV == -1 ? null : newABV);
                    System.out.println(ingredientUpdated ? "Ingredient updated successfully." : "Ingredient not found.");
                    break;

                case 8: // Search drinks by name
                    System.out.print("Enter drink name to search: ");
                    String searchDrinkName = scanner.nextLine();
                    ch.displayResults(ch.searchDrinksByName(searchDrinkName));
                    break;

                case 9: // Search ingredients by name
                    System.out.print("Enter ingredient name to search: ");
                    String searchIngredientName = scanner.nextLine();
                    ch.displayResults(ch.searchIngredientsByName(searchIngredientName));
                    break;

                case 10: // Exit
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
