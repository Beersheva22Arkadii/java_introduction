public class Strings {
    /**
     *
     * @param str1
     * @param str2
     * @return true if str2 is an anagram of str1
     * complexity O[N] two passes
     * only one additional array
     * only symbols or English letters
     * 1. the same length
     * 2. the same symbols just in different order
     */
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



