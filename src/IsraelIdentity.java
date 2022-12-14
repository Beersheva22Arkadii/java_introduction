public class IsraelIdentity {

    public static void main(String[] args) {
        System.out.println("Test generate:" + generateRandomId());
        System.out.println("Test generate2:" + generateRandomId());
    }

    public static boolean verify(int id) {
        //TODO
        /**
         * control sum should be multiple of 10  ( sum % 10 == 0)
         * for even indexes (0, 2, 4, 6, 8) digits as is
         * for odd indexes (1, 3, 5, 9) digit = digit * 2, if > 9 the sum of inner digits is taken
         * example, 123456782 => 1 + 4(2 * 2) + 3 + 8(4 * 2) +5 + 3 (6 * 2 = 12 => 1 + 2) + 7 + 7 (8 * 2=16=>1 + 6) + 2
         */

        int [] number = Numbers.getDigits(id);
        int sum = getSumTZ(number);
        return sum % 10 == 0;
    }

    public static int getSumTZ(int[] number) {
        int numberLength = number.length;
        int sum = 0;
        for (int i = 0; i < numberLength; i++) {
            int num = number[i];
            if (i % 2 == 0) {
                sum += num;
            }  else {
                int d = 2 * num;
                sum += d > 9 ? Numbers.getSumDigits(d) : d;
            }
        }
        return sum;
    }

    public static int getRandomValue(int min, int max){
        return (int)(min + Math.random() * (max - min + 1));
    }

    /**
     *
     * @return random number of 9 digits matching right Israel id
     * cycle not more than 9 iterations
     */
    public static int generateRandomId() {
        int [] arr = new int[9];
        arr[0] = getRandomValue(1,9);
        for (int i=1; i < 8; i++){
            arr[i]= getRandomValue(0, 9);
        }
        arr[8] = 0;
        int summ = getSumTZ(arr);
        int reminder = summ % 10;
        int lastDigit = reminder == 0 ? 0 : (10 - reminder);
        arr[8] = lastDigit;
        return Numbers.getNumberFromDigits(arr);
    }

}