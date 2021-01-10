import java.util.Arrays;

public class ms48 {
    public void rotate(int[][] matrix) {
        //step1:先转置
        int n = matrix.length;
        for(int i =0;i<n;i++){
            for(int j =i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //step2:再翻转
        for(int i =0;i<n;i++){
            for(int j =0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        ms48 obj = new ms48();
        int[][] martix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        obj.rotate(martix);
        for(int i =0;i<martix.length;i++){
            System.out.println(Arrays.toString(martix[i]));
        }
    }
}
