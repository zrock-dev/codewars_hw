package more_frequent_item_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayAnalyzerTest {
    @Test
    public void tests() {
        ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer();
        assertEquals(2, arrayAnalyzer.mostFrequentItemCount(new int[] {3, -1, -1}));
        assertEquals(5, arrayAnalyzer.mostFrequentItemCount(new int[] {3, -1, -1, -1, 2, 0, -1, 3, -1, 2, 4, 9, 3}));
    }

}