package Assignment1SOFT2412;

import java.util.List;

public class Menu {

    private List<Item> itemList;

    public Menu(List<Item> itemList){
        this.itemList = itemList;
    }

    public List<Item> getItemList(){return this.itemList;}
    public void setItemList(){}

    public void addItem(Item item){
        itemList.add(item);
    }
    public void show(){
        /* Alignment needs to be implemented */
        int size = itemList.size();
        for (int i = 0; i < size; i++) {
            String item_name = itemList.get(i).getName();
            String item_description = itemList.get(i).getDescription();
            double item_price = itemList.get(i).getPrice();
            if(i==0){
                System.out.println(" "+"item names"+" | "+"price"+" | "+"description"+" ");
                System.out.println("------------------------------------------");
            }
            System.out.println(i+1+"."+" "+item_name+" | "+item_price+" | "+item_description+" ");
            System.out.println("-------------------------------------------");
        }

    }
}
