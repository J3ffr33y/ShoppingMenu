package Assignment1SOFT2412;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CocaColaTest {

    @Test
    public void testName() {
        CocaCola cocacola = new CocaCola();
        assertEquals("CocaCola", cocacola.getName(), "The name should be CocaCola");
    }

    @Test
    public void testPrice() {
        CocaCola cocacola = new CocaCola();
        assertEquals(3.0, cocacola.getPrice(), "The price should be 3.0");
    }

    @Test
    public void testDescription() {
        CocaCola cocacola = new CocaCola();
        assertEquals("A classic soda", cocacola.getDescription(), "The description should be 'A classic soda'");
    }
}