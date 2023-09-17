package Assignment1SOFT2412;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OrderItemTest {
    static OrderItem orderItem;
    @BeforeAll
    public static void SetUp(){
        orderItem = new OrderItem("TestName",5,3.0);
    }

    @Test
    public void getNameTest(){
        assertEquals("TestName", orderItem.getName());
    }
    @Test
    public void getNumberTest(){
        assertEquals(5, orderItem.getNumber());
    }
    @Test
    public void getPriceTest(){
        assertEquals(3.0, orderItem.getPrice());
    }



    @Test
    public void setPriceTest(){
        double price = 63.0;
        orderItem.setPrice(price);
        assertEquals(price, orderItem.getPrice());
    }
    @Test
    public void setNumberTest() {
        int description = 51;
        orderItem.setNumber(description);
        assertEquals(description, orderItem.getNumber());
    }
    @Test
    public void setNameTest(){
        OrderItem new_orderItem = new OrderItem("TestName",5,3.0);
        new_orderItem.setName("new test name");
        assertEquals("new test name", new_orderItem.getName());
    }

}
