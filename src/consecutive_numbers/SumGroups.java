package consecutive_numbers;

public class SumGroups {
    int arrayIndex;

    public SumGroups() {
        arrayIndex = 0;
    }

    public int evaluateArray(int[] collection){
        int[] groupedCollection = collection;
        int actualCollectionSize = collection.length;
        int lastCollectionSize = 0;

        while (lastCollectionSize != actualCollectionSize){
            lastCollectionSize = actualCollectionSize;
            groupedCollection = groupNumbersByType(groupedCollection);
            actualCollectionSize = groupedCollection.length;
            arrayIndex = 0;
        }
        return actualCollectionSize;
    }

    private boolean isEven(int number){
        return number % 2 == 0;
    }

    private int[] groupNumbersByType(int[] collection){
        int evaluationNumber;
        int[] sortedCollection = new int[collection.length];
        boolean defaultGroupCondition;
        int auxIndex;

        for (int index = 0; index < collection.length; index++) {
           evaluationNumber = collection[index];
           auxIndex = index + 1;
           defaultGroupCondition = isEven(evaluationNumber);

           try {
               while (isEven(collection[auxIndex]) == defaultGroupCondition){
                   evaluationNumber += collection[auxIndex];
                   auxIndex++;
                   index++;
               }
           }catch (IndexOutOfBoundsException ignored){

           }

          add(sortedCollection, evaluationNumber);
        }

        return clearCollection(sortedCollection);
    }

    private void add(int[] collection, int number){
        collection[arrayIndex] = number;
        arrayIndex++;
    }

    private int[] clearCollection(int[] collection){
        int clearedCollectionSize = collection.length;
        for (int number:
             collection) {
            if (number == 0){
                clearedCollectionSize--;
            }
        }

        int[] clearedCollection = new int[clearedCollectionSize];
        int aux = 0;
        for (int index = 0; index < clearedCollectionSize; index++) {
            if (collection[index] != 0){
                clearedCollection[aux] = collection[index];
                aux++;
            }
        }

        return clearedCollection;
    }
}
