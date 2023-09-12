package Assignment1SOFT2412;

import java.util.ArrayList;
import java.util.List;

public class Menu {

        private List<Item> itemList = new ArrayList<Item>(){{
        add(new CocaCola());
        add(new IceTea());
        add(new Sprite());
    }};

    public List<Item> getItemList(){return this.itemList;}
    public void setItemList(){}

    public void show(){
        /* Alignment needs to be implemented */
        int size = itemList.size();
        for (int i = 0; i < size; i++) {
            String item_name = itemList.get(i).getName();
            String item_description = itemList.get(i).getDescription();
            double item_price = itemList.get(i).getPrice();
            if(i==0){
                String a = "item names";
                String b = "price";
                String c = "description";
                String str = String.format("%12s | %5s | %15s",a,b,c);
                System.out.println(str);
                System.out.println("------------------------------------------");
            }
            String str = String.format(i+1+"."+"%10s | %5s | %15s",item_name,item_price,item_description);
            System.out.println(str);
            System.out.println("-------------------------------------------");
        }

    }
    public void add(Item item){
        this.itemList.add(item);
    }
    public void update(Item item){
        for(Item i : itemList){
            if(i.getName().equals(item.getName())){
                i.setPrice(item.getPrice());
                i.setDescription(item.getDescription());
            }
        }
    }
    public void delete(Item item){
        for(Item i : itemList){
            if(i.getName().equals(item.getName())){
                itemList.remove(i);
            }
        }
    }

}
