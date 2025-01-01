public class Ingredient {
    public String name;
    public String description;
    public float ABV;


    public Ingredient(String name, String description, float ABV) {
        this.name = name;
        this.description = description;
        this.ABV = ABV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getABV() {
        return ABV;
    }

    public void setABV(float ABV) {
        this.ABV = ABV;
    }
}
