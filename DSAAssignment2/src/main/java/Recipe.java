import java.util.HashMap;
import java.util.Map;

public class Recipe {
    private Drink drink;
    private Map<Ingredient, Double> ingredientQuantities; // Ingredient and its quantity in ml

    public Recipe(Drink drink) {
        this.drink = drink;
        this.ingredientQuantities = new HashMap<>();
    }

    public void addIngredient(Ingredient ingredient, double quantity) {
        ingredientQuantities.put(ingredient, quantity);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredientQuantities.remove(ingredient);
    }



    @Override
    public String toString() {
        return "Recipe{" +
                "drink=" + drink +
                ", ingredientQuantities=" + ingredientQuantities +
                '}';
    }
}
