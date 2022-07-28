package consecutive_numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumGroupsTest {
    @Test
    public void basicTests() {
        SumGroups sumGroups = new SumGroups();
        assertEquals(6, sumGroups.evaluateArray(new int[] {2, 1, 2, 2, 6, 5, 0, 2, 0, 5, 5, 7, 7, 4, 3, 3, 9}));
        assertEquals(5, sumGroups.evaluateArray(new int[] {2, 1, 2, 2, 6, 5, 0, 2, 0, 3, 3, 3, 9, 2}));
        assertEquals(1, sumGroups.evaluateArray(new int[] {2}));
        assertEquals(2, sumGroups.evaluateArray(new int[] {1,2}));
        assertEquals(1, sumGroups.evaluateArray(new int[] {1,1,2,2}));
    }
}