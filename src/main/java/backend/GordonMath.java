package backend;

import java.util.Random;

/**
 * A class represents the GordonMath Object.
 */
public class GordonMath {
    int[] arr;

    /**
     * Constructor for GordonMath Object.
     */
    public GordonMath(){
        arr = new int[10];
    }

    /**
     * Return the array that stores a set of random numbers.
     * @return the array that stores a set of random numbers
     */
    public int[] getArray(){
        return arr;
    }

    /**
     * Create a random number from 1(inclusive) to 100(inclusive).
     * @return a random number from 1(inclusive) to 100(inclusive)
     */
    public int createRandomNumber(){
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        return randomNumber;
    }

    /**
     * Assign 10 random numbers from 1(inclusive) to 100(inclusive) in to the array.
     */
    public void assignNewNumbersToArr(){
        for(int i = 0; i < 10; i++){
            arr[i] = createRandomNumber();
        }
    }

    /**
     * Bubble sort algorithm.
     */
    public void bubbleSort() {
        int temp;
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }
}
