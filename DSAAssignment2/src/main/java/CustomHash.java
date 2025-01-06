import java.util.HashMap;
import java.util.Scanner;

public class CustomHash {
    Object[] hashTable;

    public CustomHash(int size) {
        hashTable = new Object[size];
    }

    public int hash(int key) {
        return key % hashTable.length;
    }

    public int add(Object item, int key) {
        int home = hash(key), loc;
        loc = home;
        do {
            if (hashTable[loc] == null) { // Empty - store there
                System.out.println("Storing " + item + " at " + loc);
                hashTable[loc] = item;
                return loc;
            } else { // Collision - probe ahead by one...
                System.out.println("Can't store " + item + " at " + loc +
                        ". Trying " + (loc + 1) + "...");
                loc = (loc + 1) % hashTable.length;
            }
        } while (loc != home);

        return -1;  // Table full - add failed!
    }

    public void displayHashTable() {
        System.out.println("Hash Table (using Linear Probing)\n=============");
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null)
                System.out.println(i + ". " + hashTable[i]);
        }
    }

    // Method to update a Drink in the hash table
    public void updateDrink(int key, String name, String description, String location, String imageUrl) {
        int loc = hash(key);
        int originalLoc = loc;

        while (hashTable[loc] != null) {
            if (hashTable[loc] instanceof Drink && ((Drink) hashTable[loc]).getName().equals(name)) {
                Drink drink = (Drink) hashTable[loc];
                drink.setDescription(description);
                drink.setLocation(location);
                drink.setImageUrl(imageUrl);
                System.out.println("Updated Drink: " + drink);
                return;
            }
            loc = (loc + 1) % hashTable.length;
            if (loc == originalLoc) break;
        }
        System.out.println("Drink not found.");
    }

    // Method to update an Ingredient in the hash table
    public void updateIngredient(int key, String iName, String iDescription, float ABV) {
        int loc = hash(key);
        int originalLoc = loc;

        while (hashTable[loc] != null) {
            if (hashTable[loc] instanceof Ingredient && ((Ingredient) hashTable[loc]).getiName().equals(iName)) {
                Ingredient ingredient = (Ingredient) hashTable[loc];
                ingredient.setiDescription(iDescription);
                ingredient.setABV(ABV);
                System.out.println("Updated Ingredient: " + ingredient);
                return;
            }
            loc = (loc + 1) % hashTable.length;
            if (loc == originalLoc) break;
        }
        System.out.println("Ingredient not found.");
    }

    // Method to delete a Drink from the hash table
    public void deleteDrink(int key, String name) {
        int loc = hash(key);
        int originalLoc = loc;

        while (hashTable[loc] != null) {
            if (hashTable[loc] instanceof Drink && ((Drink) hashTable[loc]).getName().equals(name)) {
                System.out.println("Deleting Drink: " + hashTable[loc]);
                hashTable[loc] = null;
                return;
            }
            loc = (loc + 1) % hashTable.length;
            if (loc == originalLoc) break;
        }
        System.out.println("Drink not found.");
    }

    // Method to delete an Ingredient from the hash table
    public void deleteIngredient(int key, String iName) {
        int loc = hash(key);
        int originalLoc = loc;

        while (hashTable[loc] != null) {
            if (hashTable[loc] instanceof Ingredient && ((Ingredient) hashTable[loc]).getiName().equals(iName)) {
                System.out.println("Deleting Ingredient: " + hashTable[loc]);
                hashTable[loc] = null;
                return;
            }
            loc = (loc + 1) % hashTable.length;
            if (loc == originalLoc) break;
        }
        System.out.println("Ingredient not found.");
    }

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
