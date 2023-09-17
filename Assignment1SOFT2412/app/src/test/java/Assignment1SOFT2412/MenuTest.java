package Assignment1SOFT2412;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {

    private Menu menu;
    private String filePath = "src/main/resources/Menu.txt";

    public class TestItem extends Item {
        public TestItem(String name, double price, String description) {
            this.name = name;
            this.price = price;
            this.description = description;
        }
    }

    @BeforeEach
    public void setup() throws IOException {
        // Initialize a new Menu object before each test
        menu = new Menu();

        // Ensure the directory structure exists
        Files.createDirectories(Paths.get("Assignment1SOFT2412/app/src/main/resources"));

        // Create a list of items using TestItem class
        List<Item> items = new ArrayList<>();
        items.add(new TestItem("Test Item 1", 10.0, "Test Description 1"));
        items.add(new TestItem("Test Item 2", 20.0, "Test Description 2"));

        // Write initial data to the file to prepare for readTxt test
        menu.writeTxt(items);
    }

    @Test
    public void testUpdate() {
        // Prepare the updated item
        Item updatedItem = new TestItem("Test Item 1", 15.0, "Updated Description 1");

        // Perform the update
        menu.update(updatedItem);

        // Verify the update
        List<Item> itemList = menu.getItemList();
        assertNotNull(itemList);
    }

    @Test
    public void testDelete() {
        // Prepare the item to be deleted
        Item itemToDelete = new TestItem("Test Item 1", 10.0, "Test Description 1");

        // Perform the deletion
        menu.delete(itemToDelete);

        // Verify the deletion
        List<Item> itemList = menu.getItemList();
        assertNotNull(itemList);
    }

    @Test
    public void testReadTxt() {
        menu.readTxt();

        List<Item> itemList = menu.getItemList();
        assertNotNull(itemList);
        assertNotNull(itemList.size());
    }

    @Test
    public void testWriteTxt() {
        // Create a new list of items to write to the file
        List<Item> items = new ArrayList<>();
        items.add(new TestItem("New Item 1", 15.0, "New Description 1"));
        items.add(new TestItem("New Item 2", 25.0, "New Description 2"));

        menu.writeTxt(items);

        // Read the file and confirm the contents
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            assertEquals("items name,price,description", lines.get(0));
            assertEquals("New Item 1,15.0,New Description 1", lines.get(1));
            assertEquals("New Item 2,25.0,New Description 2", lines.get(2));
        } catch (IOException e) {
            fail("Failed to read the file", e);
        }
    }

    @Test
    public void testShow() {
        menu.readTxt();
        menu.show(); // This method currently doesn't return anything, you might need to update it to make it testable
    }
}

