import java.util.Arrays;

public class greedy861 {

    /*
    输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]

    0 0 1 1
    1 0 1 0
    1 1 0 0

    1 1 0 0
    1 0 1 0
    1 1 0 0

    1 1 1 1
    1 0 0 1
    1 1 1 1

     */

    public int matrixScore(int[][] A) {
        if(A == null || A.length == 0 || A[0].length == 0) return 0;
        int row = A.length;
        int col = A[0].length;
        //rows
        for(int i = 0;i<row;i++){
            if(A[i][0] == 0) {
                swapZero2OneRows(A,i);
            }
        }

        //cols
        for(int i = 0;i<col;i++){
            int zeros = 0;
            int ones = 0;
            for(int j = 0;j<row;j++){
                if(A[j][i] == 0) {
                    zeros++;
                }else if(A[j][i] == 1) {
                    ones++;
                }
            }
            if(zeros > ones) {
                swapZero2OneCols(A,i);
            }
        }
        //test
        int sum = 0;
        for(int i = 0;i<A.length;i++){
            sum+= getSumRows(A[i]);
        }

        return sum;
    }

    public void swapZero2OneRows(int[][] A,int row) {
        for(int i = 0;i<A[row].length;i++){
            if(A[row][i] == 0) {
                A[row][i] = 1;
            }else{
                A[row][i] = 0;
            }
        }
    }

    public void swapZero2OneCols(int[][] A,int col) {
        for(int i = 0;i<A.length;i++){
            if(A[i][col] == 0) {
                A[i][col] = 1;
            }else{
                A[i][col] = 0;
            }
        }
    }

    public int getSumRows(int[] A){
        int sum = 0;
        int p = 0;
        for(int i = A.length-1;i>=0;i--){
            if(A[i] == 1) {
                sum+=Math.pow(2,p);
            }
            p++;
        }
        return sum;
    }

    public static void main(String[] args) {
//[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
        int[][] A = {
                {0,0,1,1},
                {1,0,1,0},
                {1,1,0,0}
        };
        greedy861 obj = new greedy861();
        int i = obj.matrixScore(A);
        System.out.println(i);
    }

}
