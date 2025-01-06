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

}