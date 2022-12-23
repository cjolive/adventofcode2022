import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void testDay1() {
        Day day = new Day1();
        assertEquals(70613, day.task1());
        assertEquals(205805, day.task2());
    }

    @Test
    public void testDay2() {
        Day day = new Day2();
        assertEquals(10595, day.task1());
        assertEquals(9541, day.task2());
    }

    @Test
    public void testDay3() {
        Day day = new Day3();
        assertEquals(7875, day.task1());
        assertEquals(2479, day.task2());
    }

    @Test
    public void testDay4() {
        Day day = new Day4();
        assertEquals(503, day.task1());
        assertEquals(827, day.task2());
    }

    @Test
    public void testDay6() {
        Day day = new Day6();
        assertEquals(1538, day.task1());
        assertEquals(2315, day.task2());
    }

    @Test
    public void testDay10() {
        Day day = new Day10();
        assertEquals(13060, day.task1());
        assertEquals(0, day.task2()); // FJUEULRZ
    }
}
