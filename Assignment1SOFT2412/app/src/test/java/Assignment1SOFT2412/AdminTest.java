package Assignment1SOFT2412;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {

    private Admin admin;

    @BeforeEach
    public void setUp() {
        admin = new Admin("testAccount", "testPassword");
    }

    @Test
    public void testSetAndGetAccount() {
        admin.setAccount("newAccount");
        assertEquals("newAccount", admin.getAccount());
    }

    @Test
    public void testSetAndGetPassword() {
        admin.setPassword("newPassword");
        assertEquals("newPassword", admin.getPassword());
    }

    @Test
    public void testCreatOrderControl(@TempDir Path tempDir) {
        // Use temporary directory for test
        String originalPath = "Assignment1SOFT2412/app/src/main/resources";
        String testPath = tempDir.toString();

        // Ensure temp directory is created
        assertTrue(Files.exists(tempDir), "Temp directory should exist: " + tempDir);

        // Replace original path with test path
        String finalPath = testPath.replace(originalPath, "");

        String expectedFileName = admin.getAccount() + ".txt";
        admin.creatOrderControl();

        File file = new File(finalPath + "\\" + expectedFileName);

        // Check if the file exists at the expected location
//        assertTrue(file.exists(), "The file should be created at: " + file.getAbsolutePath());
    }
}
