package consecutive_numbers;

import static consecutive_numbers.Utils.addToCollection;
import static consecutive_numbers.Utils.restartIndexCollection;

public class SumGroups {

    public int evaluateArray(int[] collection) {
        int[] sortedCollection = collection;
        int collectionSize = collection.length;
        int lastSize = 0;

        while (lastSize != collectionSize) {
            sortedCollection = sumNumbersByType(sortedCollection);
            lastSize = collectionSize;
            collectionSize = sortedCollection.length;
        }
        return collectionSize;
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    private int[] sumNumbersByType(int[] collection) {
        restartIndexCollection();
        int currentNumber;
        int[] sortedCollection = new int[collection.length];
        boolean toSumCondition;
        int nextNumberIndex;

        for (int index = 0; index < collection.length; index++) {
            nextNumberIndex = index + 1;
            currentNumber = collection[index];
            toSumCondition = isEven(currentNumber);

            try {
                while (isEven(collection[nextNumberIndex]) == toSumCondition) {
                    index++;
                    currentNumber += collection[nextNumberIndex];
                    nextNumberIndex++;
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}

            addToCollection(sortedCollection, currentNumber);
        }

        return removeZerosFromCollection(sortedCollection);
    }

    private int[] removeZerosFromCollection(int[] collection) {
        int sortedSize = collection.length;
        for (int number :
                collection) {
            if (number == 0) sortedSize--;
        }

        int[] clearedCollection = new int[sortedSize];
        restartIndexCollection();
        for (int number :
                collection) {
            if (number != 0) addToCollection(clearedCollection, number);
        }

        return clearedCollection;
    }
}
