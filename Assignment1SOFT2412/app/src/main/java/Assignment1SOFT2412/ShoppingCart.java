package Assignment1SOFT2412;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<Item, Integer> itemMap = new HashMap<>();

    public void add(Item item,int number){
        itemMap.put(item,number);
    }
    public void show(){
        for(Item key:itemMap.keySet()){
            String name = key.getName();
            int number = itemMap.get(key);
            String str = String.format("%-15s%5s",name,number);
            System.out.println(str);
        }
    }
}
