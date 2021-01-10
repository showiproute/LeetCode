import java.util.Arrays;

public class matrix1017 {

    //空间复杂度O(n^2)
//    public void rotate(int[][] matrix) {
//        int[][] temp = new int[matrix.length][matrix.length];
//        //对应的变化 n[i][j] -> n[j][length-i-1];
//        for(int i = 0;i<matrix.length;i++){
//            for(int j = 0;j<matrix[i].length;j++){
//                temp[j][matrix.length-i-1] = matrix[i][j];
//            }
//        }
//
//        //重新赋值
//        for(int i = 0 ;i<temp.length;i++){
//            for(int j = 0;j<temp.length;j++){
//                matrix[i][j] = temp[i][j];
//            }
//        }
//
//        return;
//    }

    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length ==0) return;
        int n = matrix.length;
        for(int i = 0;i<n/2;i++){
            for(int j =0;j<(n+1)/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4,33},
                {5, 6, 7, 8,44},
                {9, 10, 11, 12,55},
                {13, 14, 15, 16,66},
                {77,88,99,11,22}
        };
        matrix1017 obj = new matrix1017();
        obj.rotate(matrix);
        for(int i = 0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }


}
