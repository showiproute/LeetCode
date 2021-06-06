import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class array73 {

    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            helper(matrix,poll[0],poll[1]);
        }
         //test
//        for(int i = 0;i< matrix.length;i++){
//            System.out.println(Arrays.toString(matrix[i]));
//        }

        return;
    }


    public void helper(int[][] matrix,int i ,int j) {
        for(int k = 0;k<matrix[0].length;k++){
            matrix[i][k] = 0;
        }
        for(int k = 0;k<matrix.length;k++){
            matrix[k][j] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        array73 obj = new array73();
        obj.setZeroes(matrix);
    }

}
