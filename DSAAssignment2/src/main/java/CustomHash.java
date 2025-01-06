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
                System.out.println("Can't store " + item + " at " + loc + ". Trying " + (loc + 1) + "...");
                loc = (loc + 1) % hashTable.length;
            }
        } while (loc != home);

        return -1;  // Table full - add failed!
    }

    public boolean edit(int key, Object newItem) {
        int loc = hash(key);
        int home = loc;

        do {
            if (hashTable[loc] != null && hashTable[loc].getClass().equals(newItem.getClass())) {
                if (newItem instanceof Drink && ((Drink) hashTable[loc]).name.equals(((Drink) newItem).name)) {
                    hashTable[loc] = newItem;
                    System.out.println("Updated item at index " + loc);
                    return true;
                } else if (newItem instanceof Ingredient && ((Ingredient) hashTable[loc]).iName.equals(((Ingredient) newItem).iName)) {
                    hashTable[loc] = newItem;
                    System.out.println("Updated item at index " + loc);
                    return true;
                }
            }
            loc = (loc + 1) % hashTable.length;
        } while (loc != home);

        System.out.println("Item not found for update.");
        return false;
    }

    public boolean delete(int key) {
        int loc = hash(key);
        int home = loc;

        do {
            if (hashTable[loc] != null) {
                hashTable[loc] = null;
                System.out.println("Deleted item at index " + loc);
                return true;
            }
            loc = (loc + 1) % hashTable.length;
        } while (loc != home);

        System.out.println("Item not found for deletion.");
        return false;
    }

    public void displayHashTable() {
        System.out.println("Hash Table (using Linear Probing)\n=============");
        for (int i = 0; i < hashTable.length; i++)
            if (hashTable[i] != null)
                System.out.println(i + ". " + hashTable[i]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomHash ch = new CustomHash(60);
        boolean running = true;

        ch.add(new Drink("NewDrink1", "A Drink that is new", "Waterford", "image.com"), 2139012);
        ch.add(new Drink("NewDrink2", "A Drink that is new", "Waterford", "image.com"), 2139013);
        ch.add(new Ingredient("barley", "Tibet", 45), 2134132);

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Print out the entire hash table without nulls");
            System.out.println("2. Add a new Drink");
            System.out.println("3. Add a new Ingredient");
            System.out.println("4. Edit a Drink");
            System.out.println("5. Edit an Ingredient");
            System.out.println("6. Delete an item");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    ch.displayHashTable();
                    break;

                case 2:
                    System.out.print("Enter Drink Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Drink Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Drink Location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter Drink Image URL: ");
                    String url = scanner.nextLine();

                    int drinkHash = name.length() * 7 + description.length() * 13;
                    ch.add(new Drink(name, description, location, url), drinkHash);
                    break;

                case 3:
                    System.out.print("Enter Ingredient Name: ");
                    String iName = scanner.nextLine();
                    System.out.print("Enter Ingredient Description: ");
                    String iDescription = scanner.nextLine();
                    System.out.print("Enter ABV: ");
                    float abv = scanner.nextFloat();

                    int ingredientHash = iName.length() * 7 + iDescription.length() * 13;
                    ch.add(new Ingredient(iName, iDescription, abv), ingredientHash);
                    break;

                case 4:
                    System.out.print("Enter the name of the Drink to edit: ");
                    String editDrinkName = scanner.nextLine();
                    int editDrinkKey = editDrinkName.length() * 7;

                    System.out.print("Enter new Drink Description: ");
                    String newDescription = scanner.nextLine();
                    System.out.print("Enter new Drink Location: ");
                    String newLocation = scanner.nextLine();
                    System.out.print("Enter new Drink Image URL: ");
                    String newUrl = scanner.nextLine();

                    ch.edit(editDrinkKey, new Drink(editDrinkName, newDescription, newLocation, newUrl));
                    break;

                case 5:
                    System.out.print("Enter the name of the Ingredient to edit: ");
                    String editIngredientName = scanner.nextLine();
                    int editIngredientKey = editIngredientName.length() * 7;

                    System.out.print("Enter new Ingredient Description: ");
                    String newIngDescription = scanner.nextLine();
                    System.out.print("Enter new ABV: ");
                    float newABV = scanner.nextFloat();

                    ch.edit(editIngredientKey, new Ingredient(editIngredientName, newIngDescription, newABV));
                    break;

                case 6:
                    System.out.print("Enter the name of the item to delete: ");
                    String deleteName = scanner.nextLine();
                    int deleteKey = deleteName.length() * 7;

                    ch.delete(deleteKey);
                    break;

                case 7:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    2
}
