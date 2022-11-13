import java.util.Arrays;

public class MyTests {

    public static void main(String[] args) {


        int[] array = new int[]{10, 20, 20, 7, 2, 1, 25, 30, 40,50};
        int index = MyArrays.binarySearch(array, 20);

        System.out.println(index);


        System.out.println(Arrays.toString(array));


    }




}
