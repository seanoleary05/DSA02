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

    public boolean delete(Object item) {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null && hashTable[i].equals(item)) {
                hashTable[i] = null; // Remove the item
                return true; // Successful deletion
            }
        }
        return false; // Item not found
    }

    public boolean update(Object oldItem, Object newItem) {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null && hashTable[i].equals(oldItem)) {
                hashTable[i] = newItem; // Replace the old item
                return true; // Successful update
            }
        }
        return false; // Old item not found
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

    public List<Drink> searchDrinksByLocation(String location) {
        List<Drink> results = new ArrayList<>();
        for (Object obj : hashTable) {
            if (obj instanceof Drink && ((Drink) obj).getLocation().equalsIgnoreCase(location)) {
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

    public List<Ingredient> searchIngredientsByABV(float minABV, float maxABV) {
        List<Ingredient> results = new ArrayList<>();
        for (Object obj : hashTable) {
            if (obj instanceof Ingredient) {
                Ingredient ingredient = (Ingredient) obj;
                if (ingredient.getABV() >= minABV && ingredient.getABV() <= maxABV) {
                    results.add(ingredient);
                }
            }
        }
        return results;
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
