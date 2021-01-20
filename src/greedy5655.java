import java.util.Arrays;

public class greedy5655 {

    public int largestSubmatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 1;i<rows;i++){
            for(int j =0;j<cols;j++){
                if(matrix[i][j] == 1) {
                    matrix[i][j] +=matrix[i-1][j];
                }
            }
        }

        int maxVal = 0;
        for(int i = 0;i<rows;i++){
            Arrays.sort(matrix[i]);
            for(int j = cols-1;j>=0;j--){
                maxVal = Math.max(maxVal,(cols-j)*matrix[i][j]);
            }
        }

        return maxVal;
    }

    //输入：matrix = [[0,0,1],[1,1,1],[1,0,1]]
    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,1},
                {1,1,1},
                {1,0,1}
        };
        greedy5655 obj = new greedy5655();
        int i = obj.largestSubmatrix(matrix);
        System.out.println(i);
    }



}
