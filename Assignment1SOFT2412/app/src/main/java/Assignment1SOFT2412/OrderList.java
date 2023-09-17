package Assignment1SOFT2412;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class OrderList {

    private People people;
    private List<Order> orderList = new ArrayList<>();
    private Order order;
    private String fileName;
    private String path;

    public OrderList(People people,Order order){
        this.people = people;
        this.order = order;
        this.fileName = people.getAccount()+".txt";
        this.path = "src/main/resources/"  + fileName;
        readTxt();
        this.orderList.add(order);
        writeTxt();
    }
    public OrderList(){}

    public void readTxt(){
        try {

            File filename = new File(path);
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            String id = "";
            List<OrderItem> orderItemList = new ArrayList<OrderItem>();
            double total_price = 0;
            while (line != null) {
                line = br.readLine();
                if(line==null){
                    break;
                }else{
                    if(line.contains("Order ID:")){
                        id = line.split(":")[1];
                    }
                    else if(line.contains("Total price:")){
                        total_price = Double.parseDouble(line.split(":")[1]);
                        Order order1 = new Order(id,orderItemList,total_price);
                        this.orderList.add(order1);
                    } else if (line.contains("Items name,Number,Price")) {
                        orderItemList.clear();
                    } else {
                        String[] t = line.split(",");
                        OrderItem orderItem = new OrderItem(t[0],Integer.parseInt(t[1]),Double.parseDouble(t[2]));
                        orderItemList.add(orderItem);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writeTxt(){
        try {

            BufferedWriter out = new BufferedWriter(new FileWriter(path));
            for(Order i:orderList){
                String first_line ="Order ID:" + i.getId()+"\n";
                String second_line = "Items name,Number,Price\n";
                out.write(second_line);
                out.write(first_line);
                List<OrderItem> orderItemList = i.getOrderItemList();
                for(OrderItem o:orderItemList){
                    String item_name = o.getName();
                    int item_number = o.getNumber();
                    double item_price = o.getPrice();
                    String str = String.format("%s,%s,%s",item_name,item_number,item_price);
                    str+="\r\n";
                    out.write(str);
                }
                String last_line = "Total price:" + i.getTotal_price() + "\r\n";
                out.write(last_line);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void checkOrder(String checkID){
        readTxt();
        for(Order i:orderList){
            String orderID = i.getId();
            if(checkID.equals(orderID)){
                i.show();
            }
        }
    }

}
