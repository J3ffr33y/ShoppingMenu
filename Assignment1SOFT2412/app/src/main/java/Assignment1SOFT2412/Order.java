package Assignment1SOFT2412;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private double total_price;
    private List<OrderItem> orderItemList = new ArrayList<>();




    public Order(ShoppingCart cart){
        SetID();
        this.orderItemList = cart.getOrderItemList();
    }
    public Order(String id ,List<OrderItem> orderItemList,double total_price){
        this.id = id;
        this.orderItemList = orderItemList;
        this.total_price = total_price;
    }

    public void SetID(){
        this.id = UUID.randomUUID().toString();
    }
    public String getId(){return this.id;}

    public void show() {
        int size = orderItemList.size();
        double totalPrice = 0;
        for (int i = 0; i < size; i++) {
            String item_name = orderItemList.get(i).getName();
            int item_number = orderItemList.get(i).getNumber();
            double item_price = orderItemList.get(i).getPrice();
            if(i==0){
                System.out.println("Order ID:"+this.id);
                String str = String.format("%12s | %5s | %5s","Item names","Number","Price");
                System.out.println(str);
                System.out.println("------------------------------------------");
            }
            String str = String.format(i+1+"."+"%10s | %5s | %5s",item_name,item_number,item_price);
            System.out.println(str);
            System.out.println("-------------------------------------------");
            totalPrice += item_price;
        }
        this.total_price = totalPrice;
        String end = String.format("%15s","Total Price:"+totalPrice);
        System.out.println(end);
    }
    public double getTotal_price(){return this.total_price;}
    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }
}