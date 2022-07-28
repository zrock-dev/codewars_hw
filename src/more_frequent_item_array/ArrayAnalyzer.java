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
            Integer number = occurrencesOfNumbers.get(numberInArray);

            if (number == null){
                occurrencesOfNumbers.put(numberInArray, 1);
            }else {
                occurrencesOfNumbers.put(numberInArray, number + 1);
            }
        }

        return occurrencesOfNumbers.entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .get()
                .getValue();
    }
}
