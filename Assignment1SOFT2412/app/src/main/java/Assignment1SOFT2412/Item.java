package Assignment1SOFT2412;

public abstract class Item {
    String name;
    double price;
    String description;

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getName(){return name;}
    public String getDescription(){return description;}
    public double getPrice(){return price;}

}
