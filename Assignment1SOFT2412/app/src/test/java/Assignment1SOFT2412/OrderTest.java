package Assignment1SOFT2412;

import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
}