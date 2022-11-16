public class Matrices {
    public static int[][] createRandomMatrix(int rows, int columns, int minValue, int maxValue){
        int res[][] = new int [rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res[i][j] = (int) Numbers.getRandomNumber(minValue, maxValue);
            }
        }
        return res;
    }

    public static int[][] transp(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int transported [][] = new int [columns][rows];
        for (int i = 0; i< columns; i++){
            for (int j = 0; j< rows; j++){
                transported [i][j] = matrix[j][i];
            }
        }
        return transported;
    }

}