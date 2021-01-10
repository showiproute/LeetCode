public class dp221 {

    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length ==0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows+1][cols+1];

        //init
        for(int i = 0;i<rows+1;i++){
            dp[i][0] = 0;
        }
        for(int i = 0;i<cols+1;i++){
            dp[0][i] = 0;
        }

        int maxLength = 0;

        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(matrix[i][j] == '0') {
                    dp[i+1][j+1] = 0;
                }else {
                    int a = Math.min(dp[i][j], dp[i + 1][j]);
                    dp[i+1][j+1] = Math.min(dp[i][j + 1], a) +1;
                    maxLength = Math.max(maxLength,dp[i+1][j+1]);
                }
            }
        }

        return maxLength*maxLength;
    }

    public static void main(String[] args) {
        char[][] arr = {
                {1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,0,0,1,0}
        };
        dp221 obj = new dp221();
        int i = obj.maximalSquare(arr);
        System.out.println(i);
    }
}
