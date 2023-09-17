package Assignment1SOFT2412;

public class OrderItem {

    private String name;
    private double price;
    private int number;

    public OrderItem(String name,int number,double price){
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public String getName(){return name;}
    public int getNumber(){return number;}
    public double getPrice(){return price;}

}
