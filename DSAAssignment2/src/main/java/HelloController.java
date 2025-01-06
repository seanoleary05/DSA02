import java.util.Scanner;

public class HelloController{
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CustomHash ch = new CustomHash(60);

    ch.add(new Drink("NewDrink1", "A Drink that is new", "Waterford", "image.com"), 2139012);
    ch.add(new Drink("NewDrink2", "A Drink that is new", "Waterford", "image.com"), 2139013);
    ch.add(new Ingredient("barley", "Tibet", 45), 2134132);

    boolean running = true;

    while (running) {
        System.out.println("1. Print out the Entire hashtable without nulls");
        System.out.println("2. Add a new Drink");
        System.out.println("3. Add a new Ingredient");
        System.out.println("4. Update a Drink");
        System.out.println("5. Update an Ingredient");
        System.out.println("6. Delete a Drink");
        System.out.println("7. Delete an Ingredient");
        System.out.println("8. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                ch.displayHashTable();
                break;

            case 2:  // Add a new Drink to the HashTable
                System.out.print("Enter Drink Name: ");
                String name = scanner.nextLine();
                System.out.println("Enter Drink Description: ");
                String description = scanner.nextLine();
                System.out.println("Enter The Location of the Drinks origin");
                String location = scanner.nextLine();
                System.out.println("Enter a url of the drink");
                String url = scanner.nextLine();

                int hashCode = name.length() * 7 + description.length() * 13;
                Drink drink = new Drink(name, description, location, url);
                ch.add(drink, hashCode);
                System.out.println("Drink added at index." + hashCode);
                break;

            case 3: // Add a new ingredient
                System.out.print("Enter Ingredient Name: ");
                String iName = scanner.nextLine();
                System.out.println("Enter Ingredient Description: ");
                String iDescription = scanner.nextLine();
                System.out.println("Enter ABV: ");
                float ABV = scanner.nextFloat();
                scanner.nextLine(); // consume the newline character

                int iHashCode = iName.length() * 7 + iDescription.length() * 13;
                Ingredient ingredient = new Ingredient(iName, iDescription, ABV);
                ch.add(ingredient, iHashCode);
                System.out.println("Ingredient added at index." + iHashCode);
                break;

            case 4: // Update a Drink
                System.out.print("Enter the name of the Drink to update: ");
                String drinkNameToUpdate = scanner.nextLine();
                System.out.println("Enter new Description: ");
                String newDescription = scanner.nextLine();
                System.out.println("Enter new Location: ");
                String newLocation = scanner.nextLine();
                System.out.println("Enter new Image URL: ");
                String newImageUrl = scanner.nextLine();

                ch.updateDrink(drinkNameToUpdate.length() * 7 + newDescription.length() * 13, drinkNameToUpdate, newDescription, newLocation, newImageUrl);
                break;

            case 5: // Update an Ingredient
                System.out.print("Enter the name of the Ingredient to update: ");
                String ingredientNameToUpdate = scanner.nextLine();
                System.out.println("Enter new Description: ");
                String newIngredientDescription = scanner.nextLine();
                System.out.println("Enter new ABV: ");
                float newABV = scanner.nextFloat();
                scanner.nextLine();

                ch.updateIngredient(ingredientNameToUpdate.length() * 7 + newIngredientDescription.length() * 13, ingredientNameToUpdate, newIngredientDescription, newABV);
                break;

            case 6: // Delete a Drink
                System.out.print("Enter the name of the Drink to delete: ");
                String drinkNameToDelete = scanner.nextLine();
                ch.deleteDrink(drinkNameToDelete.length() * 7 + drinkNameToDelete.length() * 13, drinkNameToDelete);
                System.out.print("The Drink deleted successfully.");
                break;

            case 7: // Delete an Ingredient
                System.out.print("Enter the name of the Ingredient to delete: ");
                String ingredientNameToDelete = scanner.nextLine();
                ch.deleteIngredient(ingredientNameToDelete.length() * 7 + ingredientNameToDelete.length() * 13, ingredientNameToDelete);
                System.out.print("The Ingredient Deleted Successfully.");
                break;

            case 8: // Exit
                running = false;
                break;

            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
    scanner.close();
}



}

