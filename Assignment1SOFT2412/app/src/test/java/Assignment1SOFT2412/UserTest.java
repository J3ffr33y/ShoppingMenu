package Assignment1SOFT2412;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testConstructor() {
        User user = new User("testAccount", "testPassword");

    }

    @Test
    void testCreatOrderControl() {
        User user = new User("testAccount", "testPassword");
        user.setAccount("testAccount");
        user.creatOrderControl();

        String fileName = "testAccount.txt";
        String path = "Assignment1SOFT2412/app/src/main/resources\\" + fileName;
        File file = new File(path);

        assertTrue(file.exists());

        // Clean up the created file
        if (file.exists()) {
            file.delete();
        }
    }
}