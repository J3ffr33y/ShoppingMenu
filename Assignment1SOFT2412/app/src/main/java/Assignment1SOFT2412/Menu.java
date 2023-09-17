package Assignment1SOFT2412;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Item> itemList = new ArrayList<Item>();
    private String path = "src/main/resources/Menu.txt";
    public Menu(){
        readTxt();
    }
    public void readTxt(){
        try {
            File filename = new File(path);
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while (line != null) {
                line = br.readLine();
                if(line==null){
                    break;
                }else{
                    String[] txtRead = line.split(",");
                    Item item = new NewItem(txtRead[0],Double.parseDouble(txtRead[1]),txtRead[2]);
                    itemList.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writeTxt(List<Item> iL){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(path));
            String first_line = "items name,price,description\n";
            out.write(first_line);
            for(Item i:iL){
                String name = i.getName();
                double price = i.getPrice();
                String description = i.getDescription();
                String str = String.format("%s,%s,%s",name,price,description);
                str+="\r\n";
                out.write(str);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<Item> getItemList(){return this.itemList;}



    public void show(){
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
        writeTxt(this.itemList);
    }
    public void update(Item item){
        for(Item i : itemList){
            if(i.getName().equals(item.getName())){
                i.setPrice(item.getPrice());
                i.setDescription(item.getDescription());
            }
        }
        writeTxt(this.itemList);
    }
    public void delete(Item item){
        for(Item i : itemList){
            if(i.getName().equals(item.getName())){
                itemList.remove(i);
            }
        }
        writeTxt(this.itemList);
    }
}