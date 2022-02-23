package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-02-23
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] > target) break;
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[0][i] > target) break;
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }

        return false;
    }
}
