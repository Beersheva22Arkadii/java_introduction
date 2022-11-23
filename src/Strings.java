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
    public static void sortStringNumbers(String[] str) {
        int [] warehouse = new int[256];
        for (int i=0; i<str.length; i++){
            warehouse[Byte.valueOf(str[i])+128]++;
        }
        int strPos = 0;
        for (int i=0; i< warehouse.length; i++){
            while(warehouse[i] !=0){
                str[strPos]=Integer.toString(i-128);
                strPos++;
                warehouse[i]--;
            }
        }
    }
    public static String javaNameExp() {
        return "[a-zA-Z$][\\w$]*|_[\\w$]+";
    }

    public static String ipV4Octet( ) {
        return "\\d?\\d?|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?";
    }

    public static String ipV4( ) {
        return "(\\d?\\d?\\.|1\\d?\\d?\\.|2[0-4]?\\d?\\.|25[0-5]?\\.){3}(\\d?\\d?|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?)";
    }
}





