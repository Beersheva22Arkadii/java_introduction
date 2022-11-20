import java.util.Arrays;

public class MyTests {

    public static void main(String[] args) {


        int[] array = new int[]{10, 20, 20, 7, 2, 1, 25, 30, 40,50};
        int index = MyArrays.binarySearch(array, 10);



        System.out.println(index);


        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array));



    }
    public static int [] sumOf(int [] nums,int target){
        for (int i=0; i<nums.length; i++){
            for (int j = i+1; j< nums.length; j++ ){
                if(nums[i]+nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return nums;
    }
    public static boolean isAnagram(String str1, String str2) {
        char [] memory = new char [Character.MAX_VALUE];
        int memSum = 0;
        boolean res =false;
        char [] string1 = str1.toCharArray();
        char[] string2 = str2.toCharArray();
        if(string1.length== string2.length){
            for(int i=0; i< string1.length; i++){
                memory[string1[i]]++;
                memory[string2[i]]--;
            }

            for (int i = 0; i<Character.MAX_VALUE; i++){
                memSum+=memory[i];

            }
            res = memSum == 0? true: false;


        }return res;

    }

}
