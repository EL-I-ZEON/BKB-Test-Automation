import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrimeGapTest {

    @Test
    public void testGapExample1() {
        // Test the example gap of 2 between 3 and 50
        assertArrayEquals(new int[]{3, 5}, PrimeGap.gap(2, 3, 50));
    }

    @Test
    public void testGapExample2() {
        // Test for another pair with a gap of 2 between 5 and 50
        assertArrayEquals(new int[]{5, 7}, PrimeGap.gap(2, 5, 50));
    }

    @Test
    public void testGapExample3() {
        // Test gap of 4 between 10 and 50
        assertArrayEquals(new int[]{7, 11}, PrimeGap.gap(4, 5, 50));
    }

    @Test
    public void testNoGapFound() {
        // Test case where no such gap exists
        assertNull(PrimeGap.gap(6, 100, 110));
    }

    @Test
    public void testGapExample4() {
        // Test gap of 6 between 300 and 400
        assertArrayEquals(new int[]{359, 367}, PrimeGap.gap(8, 300, 400));
    }

    @Test
    public void testGapExample5() {
        // Test with no prime pairs in the given range
        assertNull(PrimeGap.gap(10, 50, 60));
    }

    @Test
    public void testEdgeCasePrimeLimits() {
        // Test case where both m and n are prime
        assertArrayEquals(new int[]{101, 103}, PrimeGap.gap(2, 100, 110));
    }

    @Test
    public void testPrimeGapWithLargeRange() {
        // Test with a large range to check for performance
        assertArrayEquals(new int[]{523, 541}, PrimeGap.gap(18, 500, 600));
    }
}
