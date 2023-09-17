package Assignment1SOFT2412;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IceTeaTest {

    @Test
    public void testName() {
        IceTea icetea = new IceTea();
        assertEquals("IceTea", icetea.getName(), "The name should be IceTea");
    }

    @Test
    public void testPrice() {
        IceTea icetea = new IceTea();
        assertEquals(3.0, icetea.getPrice(), "The price should be 3.0");
    }

    @Test
    public void testDescription() {
        IceTea icetea = new IceTea();
        assertEquals("Tea-flavored beverage", icetea.getDescription(), "The description should be 'Tea-flavored beverage'");
    }
}