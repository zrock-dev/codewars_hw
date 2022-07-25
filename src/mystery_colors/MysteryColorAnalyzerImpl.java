package mystery_colors;
import java.util.List;

public class MysteryColorAnalyzerImpl implements MysteryColorAnalyzer{

    @Override
    public int numberOfDistinctColors(List<Color> mysteryColors) {
        int numberOfDifferentColors = 0;
        Color[] colorsValues = Color.values();

        for (Color color:
             colorsValues) {
            if (mysteryColors.contains(color)){
                numberOfDifferentColors++;
            }
        }

        return numberOfDifferentColors;
    }

    @Override
    public int colorOccurrence(List<Color> mysteryColors, Color color) {
        return (int) mysteryColors.stream()
                .filter(colorInList -> colorInList.equals(color)).count();
    }

    public static void main(String[] args) {
        MysteryColorAnalyzer colorAnalyzer = new MysteryColorAnalyzerImpl();

        List<Color> colors = List.of(Color.GREEN, Color.RED,
               Color.GREEN, Color.RED, Color.GREEN, Color.RED, Color.BLUE);

        System.out.println("Number of distinct colors = " + colorAnalyzer.numberOfDistinctColors(colors));
        System.out.println("Number of color occurrences = " + colorAnalyzer.colorOccurrence(colors, Color.RED));
    }
}
