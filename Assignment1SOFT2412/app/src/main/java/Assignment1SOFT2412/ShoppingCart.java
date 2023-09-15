package Assignment1SOFT2412;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.SQLOutput;
import java.util.*;

public class ShoppingCart {
    private List<OrderItem> orderItemList = new ArrayList<>();


    public void add(Item item, int number) {
        String name = item.getName();
        double price = item.getPrice()*number;
        this.orderItemList.add(new OrderItem(name,number,price));
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }
}
