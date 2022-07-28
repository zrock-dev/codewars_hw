package consecutive_numbers;

public class Utils {
    private static int arrayIndex;

    protected static void addToCollection(int[] collection, int number){
        collection[arrayIndex] = number;
        arrayIndex++;
    }

    protected static void restartIndexCollection(){
        arrayIndex = 0;
    }
}
