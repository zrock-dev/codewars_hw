package more_frequent_item_array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ArrayAnalyzer {
    public int mostFrequentItemCount(int[] collection){
        int count = 0;

        if (collection.length != 0){
            count = countNumberOccurrences(collection);
        }

        return count;
    }

    private int countNumberOccurrences(int[] collection){
        HashMap<Integer, Integer> occurrencesOfNumbers = new HashMap<>();

        for (Integer numberInArray:
             collection) {

            occurrencesOfNumbers.merge(numberInArray, 1, Integer::sum);
        }

        return occurrencesOfNumbers.entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .get()
                .getValue();
    }
}
