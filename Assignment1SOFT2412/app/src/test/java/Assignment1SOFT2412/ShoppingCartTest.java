package Assignment1SOFT2412;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ShoppingCartTest {

    @Test
    public void testAdd() {
        ShoppingCart cart = new ShoppingCart();
        Item item = new ConcreteItem("TestItem", 100.0, "TestDescription"); // Assuming ConcreteItem is a concrete class extending Item
        cart.add(item, 2);

        List<OrderItem> orderItemList = cart.getOrderItemList();
        assertEquals(1, orderItemList.size());

        OrderItem orderItem = orderItemList.get(0);
        assertEquals("TestItem", orderItem.getName());
        assertEquals(2, orderItem.getNumber());
        assertEquals(200.0, orderItem.getPrice());
    }

    // Inner class ConcreteItem extending Item
    public class ConcreteItem extends Item {
        private String name;
        private double price;
        private String description;

        public ConcreteItem(String name, double price, String description) {
            this.name = name;
            this.price = price;
            this.description = description;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public double getPrice() {
            return price;
        }

        @Override
        public String getDescription() {
            return description;
        }
    }
}