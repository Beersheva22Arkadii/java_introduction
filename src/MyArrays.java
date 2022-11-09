import java.util.Arrays;

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
}