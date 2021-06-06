public class NumMatrix {

/*
给定 matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

3  3  4  8  10
5 11 14 16 17
1 3 3 4 9
4 5 5 6 13
1 1 4 4 9

3 3 4 8 10
8 14 18

 */

    public int[][] arr;

    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length ==0 ) return;
        this.arr = new int[matrix.length][matrix[0].length];
        for(int i= 0 ;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(j == 0) {
                    arr[i][j] = matrix[i][j];
                }else{
                    arr[i][j] += matrix[i][j]+arr[i][j-1];
                }
            }
        }

        for(int i = 1;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                arr[i][j] +=arr[i-1][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(arr == null || arr.length == 0) return 0;
        int leftUp = 0,rightUp = 0,leftDown = 0,rightDown = 0;
        if(row1>0 && col1 >0) {
            leftUp = arr[row1-1][col1-1];
        }
        if(row1 >0 ) {
            rightUp = arr[row1-1][col2];
        }
        if(col1>0) {
            leftDown = arr[row2][col1-1];
        }
        rightDown = arr[row2][col2];

        return rightDown - rightUp-leftDown+leftUp;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {3,0,1,4,2},
//                {5,6,3,2,1},
//                {1,2,0,1,5},
//                {4,1,0,1,7},
//                {1,0,3,0,5}
//        };
        int[][] matrix = null;
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(1,2,2,4));

    }

}
