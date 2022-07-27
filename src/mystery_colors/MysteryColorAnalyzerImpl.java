package mystery_colors;
import java.util.List;

public class MysteryColorAnalyzerImpl implements MysteryColorAnalyzer{

    @Override
    public int numberOfDistinctColors(List<Color> mysteryColors) {
        int numberOfDifferentColors = 0;

        for (Color color:
             Color.values()) {
            if (mysteryColors.contains(color)){
                numberOfDifferentColors++;
            }
        }

        return numberOfDifferentColors;
    }

    @Override
    public int colorOccurrence(List<Color> mysteryColors, Color color) {
        return (int) mysteryColors.stream()
                .filter(colorInList -> colorInList.equals(color))
                .count();
    }
}
