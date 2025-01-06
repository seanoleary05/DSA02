public class Ingredient implements Comparable<Ingredient> {
    public String iName;
    public String iDescription;
    public float ABV;


    public Ingredient(String iName, String iDescription, float ABV) {
        this.iName = iName;
        this.iDescription = iDescription;
        setABV(ABV);
    }


    public int compareTo(Ingredient o) {
        return this.iName.compareTo(o.iName);
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        if ((iName.length() > 4) && (iName.length() < 20))
            this.iName = iName;
    }

    public String getDescription() {
        return iDescription;
    }

    public void setiDescription(String iDescription) {
        if ((iDescription.length() > 5) && (iDescription.length() < 50))
            this.iDescription = iDescription;
    }

    public float getABV() {
        return ABV;
    }

    public void setABV(float ABV) {
        if((ABV > 0.01) && (ABV < 99.1))
            this.ABV = ABV;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + iName + '\'' +
                ", description='" + iDescription + '\'' +
                ", ABV=" + ABV +
                '}';
    }
}
