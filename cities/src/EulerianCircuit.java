
public class EulerianCircuit {

    public static int[][] createMatrix(String[] arr){
        int[][] matrix = new int[32][32];
        for (int i = 0; i < arr.length; i++){
            matrix[(int)arr[i].charAt(0) - 1040][(int)arr[i].charAt(arr[i].length() - 1) - 1072] = 1;
        }
        return matrix;
    }

    public boolean doesEulerCycleExist(int [][] matrix){
        int degreeIn = 0;
        int degreeOut = 0;
        int counter = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                degreeIn += matrix[i][j];
                degreeOut += matrix[j][i];
            }
            if (degreeIn == degreeOut){
                counter++;
            }
        }
        if (counter == matrix.length){
            return true;
        }
        return false;
    }

}