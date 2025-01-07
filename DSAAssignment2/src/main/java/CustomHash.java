import java.util.ArrayList;
import java.util.List;

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
                hashTable[loc] = item;
                return loc;
            } else { // Collision - probe ahead by one
                loc = (loc + 1) % hashTable.length;
            }
        } while (loc != home);
        return -1; // Table full - add failed!
    }

    // Delete a drink by name
    public boolean deleteDrinkByName(String name) {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] instanceof Drink && ((Drink) hashTable[i]).getName().equalsIgnoreCase(name)) {
                hashTable[i] = null; // Remove the drink
                return true; // Successful deletion
            }
        }
        return false; // Drink not found
    }

    // Delete an ingredient by name
    public boolean deleteIngredientByName(String name) {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] instanceof Ingredient && ((Ingredient) hashTable[i]).getiName().equalsIgnoreCase(name)) {
                hashTable[i] = null; // Remove the ingredient
                return true; // Successful deletion
            }
        }
        return false; // Ingredient not found
    }

    // Search methods (unchanged)
    public List<Drink> searchDrinksByName(String name) {
        List<Drink> results = new ArrayList<>();
        for (Object obj : hashTable) {
            if (obj instanceof Drink && ((Drink) obj).getName().equalsIgnoreCase(name)) {
                results.add((Drink) obj);
            }
        }
        return results;
    }



    public List<Ingredient> searchIngredientsByName(String name) {
        List<Ingredient> results = new ArrayList<>();
        for (Object obj : hashTable) {
            if (obj instanceof Ingredient && ((Ingredient) obj).getiName().equalsIgnoreCase(name)) {
                results.add((Ingredient) obj);
            }
        }
        return results;
    }

    public boolean updateDrinkByName(String name, String newDescription, String newLocation, String newImageUrl) {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] instanceof Drink && ((Drink) hashTable[i]).getName().equalsIgnoreCase(name)) {
                Drink drink = (Drink) hashTable[i];
                if (newDescription != null) drink.setDescription(newDescription);
                if (newLocation != null) drink.setLocation(newLocation);
                if (newImageUrl != null) drink.setImageUrl(newImageUrl);
                return true;
            }
        }
        return false; // Drink not found
    }

    // Update ingredient details by name
    public boolean updateIngredientByName(String name, String newDescription, Float newABV) {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] instanceof Ingredient && ((Ingredient) hashTable[i]).getiName().equalsIgnoreCase(name)) {
                Ingredient ingredient = (Ingredient) hashTable[i];
                if (newDescription != null) ingredient.setiDescription(newDescription);
                if (newABV != null) ingredient.setABV(newABV);
                return true;
            }
        }
        return false; // Ingredient not found
    }

    // Display a list of results
    public void displayResults(List<?> results) {
        if (results.isEmpty()) {
            System.out.println("No results found.");
        } else {
            for (Object obj : results) {
                System.out.println(obj);
            }
        }
    }
}
