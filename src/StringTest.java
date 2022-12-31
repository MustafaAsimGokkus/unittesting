import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class StringTest {

    @Test
    void length_basic(){
        int actualLength = "abcdefg".length();
        int expectedLength = 7;
        assertEquals(expectedLength,actualLength);
    }
}
