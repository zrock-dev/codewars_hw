package more_frequent_item_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayAnalyzer {

    public int analyzeArray(int[] arrayToAnalyze){
        int count = 0;
        if (arrayToAnalyze.length > 0){
            ArrayList<Integer> sortedList = sortArray(arrayToAnalyze);
            count = sortedList.stream().
                    sorted().
                    collect(Collectors.toList())
                    .get(sortedList.size() - 1);
        }
        return count;
    }

    private ArrayList<Integer> sortArray(int[] arrayToAnalyze){
        ArrayList<Integer> sortedList = new ArrayList<>();

        for (int index = 0; index < arrayToAnalyze.length; index++) {
            int numberUnderScoop = arrayToAnalyze[index];
            int numberOccurrences = 0;

            if (numberUnderScoop != 0){
                for (int ind = 0; ind < arrayToAnalyze.length; ind++) {
                    if (arrayToAnalyze[ind] == numberUnderScoop){
                        numberOccurrences++;
                        arrayToAnalyze[ind] = 0;
                    }
                }
            }

            sortedList.add(numberOccurrences);
        }

        return sortedList;
    }
}
