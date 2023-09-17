package Assignment1SOFT2412;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

    static Order order;
    static PrintStream console = null;
    static ByteArrayOutputStream bytes = null;
    static List<OrderItem> orderItemList = new ArrayList<>();
    @BeforeClass
    public static void SetList(){
        orderItemList.add(new OrderItem("test",10,3.0));
    }

    @BeforeAll
    public static void setUp(){
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
        SetList();
        order = new Order("testId",orderItemList,6.6);
        Order order1 = new Order(new ShoppingCart());
    }

    @Test
    public void getIdTest(){
        assertEquals("testId",order.getId());
    }
    @Test
    public void getTotal_priceTest(){
        assertEquals(6.6,order.getTotal_price());
    }
    @Test
    public void getOrderItemListTest(){
        assertEquals(orderItemList,order.getOrderItemList());
    }
    @Test
    public void setID(){
        Order new_order = new Order("testId",orderItemList,6.6);
        new_order.SetID();
        String new_id = new_order.getId();
        assertEquals(new_id, new_order.getId());
    }
    @org.junit.Before
    public void Beforetest() throws Exception {
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    @org.junit.After
    public void aftertest() throws Exception {
        System.setOut(console);
    }

    @Test
    public void ShowTest() throws Exception {
        String str = "";
        String str1 = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        double tp =0;
        int size = orderItemList.size();
        for (int i = 0; i < size; i++) {
            String item_name = orderItemList.get(i).getName();
            int item_number = orderItemList.get(i).getNumber();
            double item_price = orderItemList.get(i).getPrice();
            if(i==0){
                str1 = ("Order ID:"+order.getId()+"\r\n");
                str2 = String.format("%12s | %5s | %5s","Item names","Number","Price"+"\r\n");
                str3 = ("------------------------------------------"+"\r\n");
            }
            String aa = String.format(i+1+"."+"%10s | %5s | %5s",item_name,item_number,item_price);
            str4 = aa + "\r\n";
            str5 = "-------------------------------------------"+"\r\n";
            str6 = str4 + str5;
            tp += item_price;
        }
        String end = String.format("%15s","Total Price:"+tp);
        str = str1 + str2 + str3 +str6 + end;

        order.show();
        String s = new String(str);
        assertEquals(s,bytes.toString().trim());
    }
}