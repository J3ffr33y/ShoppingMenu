package Assignment1SOFT2412;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class AskTest {
    @Test
    public void testInitial_query(){
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Ask ask = new Ask();
        assertEquals(1, ask.Initial_query());

        input="2\n";
        in= new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(2, ask.Initial_query());

        input="3\n";
        in= new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(3, ask.Initial_query());

    }
}
