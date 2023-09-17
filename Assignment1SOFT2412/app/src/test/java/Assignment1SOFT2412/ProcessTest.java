//package Assignment1SOFT2412;
//
//import org.junit.After;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
//import static org.junit.Assert.assertTrue;
//
//public class ProcessTest {
//
//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private final PrintStream originalOut = System.out;
//
//    @BeforeEach
//    public void setUp() {
//        System.setOut(new PrintStream(outContent));
//    }
//
//    @Test
//    public void testProcess() {
//        // Simulate user login
//
//        // Simulate admin login
//
//        // Simulate user registration
//
//        // Simulate admin registration
////        String input = "2\n" +  // Simulate user choosing to registrate
////                "1\n" +  // Simulate creating admin account
////                "admin\n" + // Simulate user entering username
////                "password123\n" + // Simulate user entering password
////                "2\n" + // Simulate user choosing item 2 in next step
////                "1\n" + // Simulate user choosing quantity 1 in the next step
////                "2\n" + // Simulate not continue buying
////                "2\n" + // Simulate delivery
////                "2\n"; // Simulate end session
////        System.setIn(new ByteArrayInputStream(input.getBytes()));
////
////        Process process = new Process();
////        process.process();
////
////        String output = outContent.toString();
////        assertTrue(output.contains("Choose your identity:"));
////
////        assertTrue(output.contains("Create an Account:"));
////
////        assertTrue(output.contains("Create an Password:"));
////
////        assertTrue(output.contains("Please enter the line number of the product you want to buy:"));
////
////        assertTrue(output.contains("Please enter the number of the product you want to buy:"));
////
////        assertTrue(output.contains("Do you want to continue buying?"));
////
////        assertTrue(output.contains("Please select the options below:"));
////
////        assertTrue(output.contains("Please select the options below:"));
//
//        // Simulate add item, update item, delete item
//
//        // Simulate shooping and order handling
//
//    }
//
//    @After
//    public void restoreStreams() {
//        System.setOut(originalOut);
//        System.setIn(System.in);
//    }
//
//    public class Ask_sim extends Ask {
//
//    }
//}
