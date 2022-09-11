import java.util.*;

public class Main {
    public static void main(String[] args) {
        Boolean BUBBLE_SORT = true; //If false, will do a Collections.sort instead
        int RANDOM_ARRAY_SIZE = 100;

        Sort sort =  new Sort();
        int[] randomIntArray = generateRandomIntArray(RANDOM_ARRAY_SIZE);
        int[] sortedIntArray = BUBBLE_SORT ? sort.bubbleSort(randomIntArray) : sort.sort(randomIntArray);
        HashMap<Integer, Integer> repeatedNumbersMap = sort.repeatedNumbersMap(sortedIntArray);

        System.out.println("Random: " + Arrays.toString(randomIntArray));
        System.out.println("Sorted: " + Arrays.toString(sortedIntArray));
        System.out.println("Map: " + repeatedNumbersMap.toString());
    }

    private static int[] generateRandomIntArray(int arraySize){
        Random rand = new Random();
        int[] randomIntArray = new int[arraySize];

        for (int i = 0; i < randomIntArray.length; i++) {
            randomIntArray[i] = rand.nextInt(arraySize);
        }
        return randomIntArray;
    }

}

class Sort {
    public int[] sort(int[] randomIntArray){
        ArrayList<Integer> sortedArray = arrayToList(randomIntArray);
        Collections.sort(sortedArray);
        return listToArray(sortedArray);
    }

    public int[] bubbleSort(int[] array){
        boolean repeat;
        do {
            repeat = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int hold = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = hold;
                    repeat = true;
                }
            }

        } while (repeat);
        return array;
    }

    public HashMap<Integer, Integer> repeatedNumbersMap(int[] sortedArray){
        HashMap<Integer, Integer> numberRepetitions = new HashMap<>();
        int repeatCount = 1;
        for(int i = 0; i < sortedArray.length; i++){

            if(i == sortedArray.length-1){
                if(sortedArray[i] == sortedArray[i-1]){
                    repeatCount++;
                    numberRepetitions.put(sortedArray[i], repeatCount);
                } else {
                    numberRepetitions.put(sortedArray[i], 1);
                }
                break;
            }

            if(sortedArray[i] == sortedArray[i+1]){
                repeatCount++;
            } else {
                numberRepetitions.put(sortedArray[i], repeatCount);
                repeatCount = 1;
            }
        }
        return numberRepetitions;
    }

    private ArrayList<Integer> arrayToList(int[] array){
        ArrayList<Integer> sortedArray = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            sortedArray.add(array[i]);
        }
        return sortedArray;
    }

    private int[] listToArray(ArrayList<Integer> list){
        int[] array = new int[list.size()];
        for(int j = 0; j < list.size(); j++){
            array[j] = list.get(j);
        }
        return array;
    }
}