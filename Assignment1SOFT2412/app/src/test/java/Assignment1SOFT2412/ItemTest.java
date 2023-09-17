package Assignment1SOFT2412;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    // 测试用的子类，以便我们能够实例化Item
    class TestItem extends Item {}

    private TestItem item;

    @BeforeEach
    public void setup() {
        item = new TestItem();
    }

    @Test
    public void testSetName() {
        item.setName("TestName");
        assertEquals("TestName", item.getName());
    }

    @Test
    public void testSetPrice() {
        item.setPrice(10.5);
        assertEquals(10.5, item.getPrice());
    }

    @Test
    public void testSetDescription() {
        item.setDescription("TestDescription");
        assertEquals("TestDescription", item.getDescription());
    }

    @Test
    public void testGetName() {
        item.name = "AnotherTestName";
        assertEquals("AnotherTestName", item.getName());
    }

    @Test
    public void testGetPrice() {
        item.price = 5.5;
        assertEquals(5.5, item.getPrice());
    }

    @Test
    public void testGetDescription() {
        item.description = "AnotherTestDescription";
        assertEquals("AnotherTestDescription", item.getDescription());
    }
}

