public class Ingredient {
    public String iName;
    public String description;
    public float ABV;


    public Ingredient(String iName, String description, float ABV) {
        this.iName = iName;
        this.description = description;
        this.ABV = ABV;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
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

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + iName + '\'' +
                ", description='" + description + '\'' +
                ", ABV=" + ABV +
                '}';
    }
}
