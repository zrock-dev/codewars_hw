package mystery_colors;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MysteryColorAnalyzerImplTest {
    MysteryColorAnalyzerImpl colorAnalyzer = new MysteryColorAnalyzerImpl();

    @Test
    public void ListHasAllColorsAvailableInColorEnum(){
        List<Color> colors = List.of(Color.GREEN, Color.RED, Color.BLUE, Color.GREEN, Color.RED, Color.BLUE);
        assertEquals(3, colorAnalyzer.numberOfDistinctColors(colors));
    }

    @Test
    public void ListOnlyWithTwoColors(){
        List<Color> colors = List.of(Color.GREEN, Color.RED, Color.GREEN, Color.RED, Color.GREEN, Color.RED);
        assertEquals(2, colorAnalyzer.numberOfDistinctColors(colors));
    }

    @Test
    public void OccurrencesOfTheSameColorInList(){
        List<Color> colors = List.of(Color.GREEN, Color.RED, Color.BLUE, Color.RED, Color.BLUE, Color.RED);
        assertEquals(1, colorAnalyzer.colorOccurrence(colors, Color.GREEN));
    }
}