package Assignment1SOFT2412;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AskTest {

    private Ask ask;

    @BeforeEach
    public void setup() {

        ask = new Ask();
        LoginSystem loginSystem = new LoginSystem();


        Admin admin = new Admin("testUser", "testPassword");
        loginSystem.add(admin);

        // Set the LoginSystem in Ask class
        ask.loginSystem = loginSystem;
    }
    @Test
    public void testInitial_query() {
        InputStream originalSystemIn = System.in;
        try {
            // Test for initial option 1
            String input = "1\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            assertEquals(1, ask.Initial_query());

            input = "2\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            assertEquals(2, ask.Initial_query());

            input = "3\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            assertEquals(3, ask.Initial_query());

        } finally {
            System.setIn(originalSystemIn);
        }
    }
    @Test
    public void testRegistration1() {
        final InputStream originalSystemIn = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);

        int result = ask.Registration1();
        assertEquals(1, result);

        System.setIn(originalSystemIn);
    }
    @Test
    public void dashboard() {
        final InputStream originalSystemIn = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);

        int result = ask.dashboard();
        assertEquals(1, result);

        System.setIn(originalSystemIn);
    }
    @Test
    public void isDashboard() {
        final InputStream originalSystemIn = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);

        int result = ask.isDashboard();
        assertEquals(1, result);

        System.setIn(originalSystemIn);
    }
    @Test
    public void isPurchase() {
        final InputStream originalSystemIn = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);

        int result = ask.isPurchase();
        assertEquals(1, result);

        System.setIn(originalSystemIn);
    }

    @Test
    public void end() {
        final InputStream originalSystemIn = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);

        int result = ask.end();
        assertEquals(1, result);

        System.setIn(originalSystemIn);
    }
    @Test
    public void send() {
        final InputStream originalSystemIn = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);

        int result = ask.send();
        assertEquals(1, result);

        System.setIn(originalSystemIn);
    }
    @Test
    public void getNewItem() {

        final InputStream originalSystemIn = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("IP15PRO\n88.8\nhello\n".getBytes());
        System.setIn(in);
        Ask obj =new Ask();
        Item newItem = obj.getNewItem();
        assertEquals("IP15PRO", newItem.getName());
        assertEquals(88.8, newItem.getPrice());
        assertEquals("hello", newItem.getDescription());

        System.setIn(originalSystemIn);

    }

    @Test
    public void testID() {

        final InputStream originalSystemIn = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("testID\n".getBytes());
        System.setIn(in);
        Ask obj = new Ask();
        String id = obj.ID();
        assertEquals("testID", id);
        System.setIn(originalSystemIn);
    }


    @Test
    public void testRegistration_Admin() {
        final InputStream originalSystemIn = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("testAdmin\ntestPassword\n".getBytes());
        System.setIn(in);

        Admin admin = ask.Registration_Admin();
        assertEquals("testAdmin", admin.getAccount());
        assertEquals("testPassword", admin.getPassword());

        System.setIn(originalSystemIn);
    }

    @Test
    public void testRegistration_User() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        ask.Registration_User();



        System.setOut(System.out);
    }
    @Test
    public void testMenuShow_or_dashboard() {
        final InputStream originalSystemIn = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(in);

        int result = ask.menuShow_or_dashboard();
        assertEquals(2, result);

        System.setIn(originalSystemIn);
    }

    @Test
    public void testLogIn() {
        // Save the original System.in stream
        final InputStream originalSystemIn = System.in;

        try {
            // Provide the username and password as user input
            ByteArrayInputStream in = new ByteArrayInputStream("testUser\ntestPassword\n".getBytes());
            System.setIn(in);

            // Run the LogIn method
            boolean loginResult = ask.LogIn();

            // Validate the result
            assertTrue(loginResult);
        } finally {
            // Restore the original System.in stream
            System.setIn(originalSystemIn);
        }
    }
}
