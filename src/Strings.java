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

    public static boolean isArithmeticExpression(String expression) {
        expression = expression.replaceAll("\\s+", "");
        return expression.matches(arithmeticExpression());
    }

    private static String operator() {

        return "([-+*/])";
    }

    /**
     *
     * @param expression
     * @param values
     * @param namesSorted - variable names sorted
     * @return computed value of a given expression or Double.NaN
     */
    public static Double computeArithmenticExpression(String expression, double values[], String names[]) {
        // 10 (* 2)
        // 10 * 2(())
        Double res = Double.NaN;
        if (isArithmeticExpression(expression) && checkBraces(expression)) {	//full braces checking
            expression = expression.replaceAll("[\\s()]+", "");					//braces and non printable symbols removed from expression!
            String operands[] = expression.split(operator());
            String operators[] = expression.split(operand());
            res = getOperandValue(operands[0], values, names);
            int index = 1;
            while (index < operands.length && !res.isNaN()) {
                double operandValue = getOperandValue(operands[index], values, names);
                res = computeOperation(res, operandValue, operators[index]);
                index++;
            }

        }

        return res;
    }

    private static Double computeOperation(Double operand1, double operand2, String operator) {
        Double res = Double.NaN;
        if(!Double.isNaN(operand2)) {
            switch(operator) {
                case "+": res = operand1 + operand2; break;
                case "-": res = operand1 - operand2; break;
                case "*": res = operand1 * operand2; break;
                case "/": res = operand1 / operand2; break;
                default: res = Double.NaN;
            }
        }
        return res;
    }

    private static Double getOperandValue(String operand, double[] values, String[] names) {
        double res = Double.NaN;
        if (operand.matches("\\d+\\.?\\d*|\\.\\d+")) {res =  Double.parseDouble(operand);}
        if (operand.matches(javaNameExp())) {
            int indexName = Arrays.binarySearch(names, operand);
            if (indexName >= 0) {res = values[indexName];}

        }
        return res;
    }

    public static boolean checkBraces(String expression) {				//parity check only
        char[] helper = expression.toCharArray();
        int bracesCounter = 0;
        for (int i = 0; i < helper.length; i++) {
            if (expression.charAt(i) == '(') {bracesCounter++;}
            if (expression.charAt(i) == ')') {bracesCounter--;}

        }
        return bracesCounter == 0 ? true : false;
    }




}





