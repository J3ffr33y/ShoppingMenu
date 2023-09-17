package Assignment1SOFT2412;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PeopleTest {

    @Test
    void testGetAndSetAccount() {
        People people = new ConcretePeople();
        people.setAccount("TestAccount");
        assertEquals("TestAccount", people.getAccount());
    }

    @Test
    void testGetAndSetPassword() {
        People people = new ConcretePeople();
        people.setPassword("TestPassword");
        assertEquals("TestPassword", people.getPassword());
    }

    @Test
    void testGetAndSetName() {
        People people = new ConcretePeople();
        people.name = "TestName";
        assertEquals("TestName", people.getName());
    }

    @Test
    void testGetOrderList() {
        People people = new ConcretePeople();
        List<Order> orders = new ArrayList<>();
        orders.add(new Order());  // Assuming Order is a valid class
        assertEquals(people.orderList, people.getOrderList());
    }

    // A concrete subclass of People to allow instantiation for testing
    static class ConcretePeople extends People {
    }

    // Mock Order class, replace with your actual Order class
    static class Order {
    }
}