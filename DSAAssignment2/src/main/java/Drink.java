public class Drink {
    public String name;
    public String description;
    public String location;
    public String imageUrl;

    public Drink(String name, String description, String location, String imageUrl) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.imageUrl = imageUrl;
    }


    public int compareTo(Drink o) {
        return this.name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        if ((name.length() > 4) && (name.length() < 25))
        this.name = name;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description)
    {
        if((description.length() > 5) && (description.length() < 70))
            this.description = description;

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {

        if ((location.length() > 4) && (location.length() < 25))
            this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {

        if ((imageUrl.length() > 10) && (imageUrl.length() < 100))
            this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
