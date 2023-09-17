package Assignment1SOFT2412;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
public class OrderListTest {
    static OrderList orderList;
    static List<OrderItem> orderItemList = new ArrayList<>();
    @BeforeClass
    public static void SetList(){
        orderItemList.add(new OrderItem("test",10,3.0));
    }
    @BeforeAll
    public void setUp(){
        orderList = new OrderList(new Admin("test1","a"),new Order("testId",orderItemList,6.6));
        OrderList orderList1 = new OrderList();
    }

}
