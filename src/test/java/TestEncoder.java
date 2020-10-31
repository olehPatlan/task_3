import static org.junit.Assert.*;
import org.junit.Test;

public class TestEncoder {
    @Test
    public void testEncode(){
        assertEquals("00 0 0 0 00 000 0 000",Encoder.encode("G"));
        assertEquals("00 0 0 0 00 000 0 000 00 0 0 0 00 00 0 0000",Encoder.encode("GO"));
        assertEquals("00 0 0 00 00 0000 0 0",Encoder.encode("a"));
    }
}
