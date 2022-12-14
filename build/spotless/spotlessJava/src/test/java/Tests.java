import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void testDay1() {
        Day day = new Day1();
        assertEquals(70613, day.task1());
        assertEquals(205805, day.task2());
    }
}
