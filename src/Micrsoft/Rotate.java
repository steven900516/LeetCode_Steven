package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-01-06
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix.length;
        int limit = m / 2;
        int count = 0;
        int up = 0;
        int right = 0;
        int left = m - 1;
        int down = n - 1;
        while(count < limit){
            if(up == m - count - 1){
                count++;
                left = m - 1 - count;
                right = count;
                up = count;
                down = n - 1 - count;
                continue;
            }
            int temp = matrix[right][n - 1 - count];   //3
            matrix[right][n - 1 - count] = matrix[count][up];  //3-->1
            int temp2 = matrix[m - 1 - count][down];   //9
            matrix[m - 1 - count][down] = temp;   //9-->3
            int temp3 = matrix[left][count];  //7
            matrix[left][count] = temp2;
            matrix[count][up] = temp3;
            left--;
            up++;
            right++;
            down--;
        }
    }
}
