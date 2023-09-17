package Assignment1SOFT2412;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SpriteTest {

    @Test
    public void testName() {
        Sprite sprite = new Sprite();
        assertEquals("Sprite", sprite.getName(), "The name should be Sprite");
    }

    @Test
    public void testPrice() {
        Sprite sprite = new Sprite();
        assertEquals(3.0, sprite.getPrice(), "The price should be 3.0");
    }

    @Test
    public void testDescription() {
        Sprite sprite = new Sprite();
        assertEquals("Lemon soda", sprite.getDescription(), "The description should be 'Lemon soda'");
    }
}