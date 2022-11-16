import java.util.Arrays;
import java.util.Random;


public class MyArrays {
    /**
     * import java.util.Arrays;
     *
     * @param array
     * @param number
     * @return new array with added at end a given number
     */
    public static int[] addsNumber(int[] array, int number) {
        // TODO
        int[] copy = Arrays.copyOf(array, array.length + 1);
        copy[array.length] = number;
        return copy;
    }

    /**
     * @param array
     * @param index
     * @return new array with no number at a given index in a given array
     * if index doesn't exist in a given array it returns the same array
     */
    public static int[] removeNumber(int[] array, int index) {
        //TODO
        // use standard class System, method arraycopy
        // [0,1,2,3,4,5]  = index = 3 => [0,1,2,4,5]   [0,1,2] + [4,5]
        if ((index < 0) && (index >= array.length)) {
            return array;
        }
        int[] arraycopy = new int[array.length - 1];
        // copy = [n,n,n,n,n]
        // [0,1,2]
        // copy = [n,n,n,n,n] => [0,1,2,n,n]  => [0,1,2,4,5]
        System.arraycopy(array, 0, arraycopy, 0, index);  // source_array, source_index, dest_array, dest_index, lent)
        // copy = [0,1,2,n,n]
        System.arraycopy(array, index + 1, arraycopy, index, array.length - index - 1);
        return arraycopy;
    }

    /**
     * @param arraySorted - sorted array
     * @param number
     * @return new array with inserted number at an index for keeping array sorted
     */
    public static int[] insertSorted(int[] arraySorted, int number) {
        //TODO
        // use the method binarySearch of the standard class Arrays
        // use the method arraycopy of the standard class System
        // [0,1,2,3,5,6] => number = 4 => [0,1,2,3,4,5,6]
        //							 => number = 3 => [0,1,2,3,3,5,6]
        //							 => number = 0 => [0,0,1,2,3,5,6]

        // [0,1,2,3,5,6] => number = 4 => [0,1,2,3,n,5,6]
        int index = Arrays.binarySearch(arraySorted, number);
        int[] newArray = new int[arraySorted.length + 1];
        System.arraycopy(arraySorted, 0, newArray, 0, index);
        System.arraycopy(arraySorted, index, newArray, index + 1, arraySorted.length - index);
        newArray[index] = number;
        return newArray;
    }

    public static int binarySearch(int arraySorted[], int number) {

        int left = 0;
        int right = arraySorted.length - 1;
        int middle = right / 2;

        while (left <= right && arraySorted[middle] != number) {
            if (number < arraySorted[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }
        if (left > right) return -left;
        else
            while (middle >= 0 && arraySorted[middle] == number) {
                middle--;
            }
        return middle + 1;
    }

    public static int[] bubbleSort(int array[]) {

        int arr[] = new int[array.length];
        System.arraycopy(array, 0, arr, 0, array.length);


        boolean swappedSomething = true;

        int index = array.length - 1;

        while (swappedSomething) {
            swappedSomething = false;

            for (int i = 0; i < index; i++) {

                if (arr[i] > arr[i + 1]) {
                    swappedSomething = true;
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                }
            }
            index--;

        }
        return arr;


    }

    public static boolean isOneSwapForSorted(int unsortedArr[]) {
        int arraySorted[] = new int[unsortedArr.length];
        System.arraycopy(unsortedArr, 0, arraySorted, 0, unsortedArr.length);

        Arrays.sort(arraySorted);
        int count = 0;
        for (int i = 0; i < unsortedArr.length; i++) {
            if (arraySorted[i] != unsortedArr[i]) {
                count++;
            }
        }


        return count == 2 ? true : false;
    }

    /**
     * @param array of short positive numbers
     * @param sum
     * @return true if array contains two numbers, sum of which equals a given sum
     */

    // [4, 7, 3, 2, 5, 8, 20, 10]
    //9
    //sum - number
    // array[i]+array[j]=sum
    //arr[j]=num - arr[i]
    // arr[j]=1010-10
    static public boolean isSum2(short array[], short sum) {
        boolean memory[] = new boolean[Short.MAX_VALUE];

        for (int i = 0; i < array.length; i++) {
            if (array[i] <= sum) {

                int diff = sum - array[i];
                if (memory[diff]) {
                    return true;
                }
                memory[array[i]] = true;

            }
        }
        return false;
    }


}







