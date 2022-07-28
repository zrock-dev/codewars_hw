package consecutive_numbers;

public class SumGroups {

    public int evaluateArray(int[] collection){
        int[] groupedCollection = collection;
        int lastCollectionSize = collection.length;
        int actualCollectionSize = 0;

        do {
            groupedCollection = groupNumbersByType(groupedCollection);
            actualCollectionSize = groupedCollection.length;
        }
        while (lastCollectionSize != actualCollectionSize);

        return actualCollectionSize;
    }

    private boolean isEven(int number){
        return number % 2 == 0;
    }

    private int[] groupNumbersByType(int[] collection){
        int lastUsedNumber;
        int actualNumber;
        int indexOfSortedCollection = 0;
        int[] sortedCollection = new int[collection.length];

        for (int index = 0; index <= collection.length; index++) {
           lastUsedNumber = collection[index];
           actualNumber = collection[index + 1];

            if (isEven(actualNumber) && isEven(lastUsedNumber)){
                sortedCollection[indexOfSortedCollection] += actualNumber + lastUsedNumber;
                indexOfSortedCollection++;
            } else if (!isEven(actualNumber) && !isEven(lastUsedNumber)) {
                sortedCollection[indexOfSortedCollection] += actualNumber + lastUsedNumber;
                indexOfSortedCollection++;
            }
        }
        return sortedCollection;
    }

}
