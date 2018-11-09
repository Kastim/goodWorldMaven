import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {

    @Test
    public void getMessage() {
        for (int i = 6; i < 9; i++) {
            assertEquals("morning", Message.getMessage(i));
            }
        for (int i = 9; i < 19; i++) {
            assertEquals("day", Message.getMessage(i));
        }
        for (int i = 19; i < 23; i++) {
            assertEquals("evening", Message.getMessage(i));
        }
        for (int i = 23; i < 6; i++) {
            assertEquals("night", Message.getMessage(i));
        }
    }
}