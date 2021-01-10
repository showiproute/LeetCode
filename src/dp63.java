import java.util.Arrays;

public class dp63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length ==0) return 0;
        int[][] dp = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        //init
        for(int i = 0;i<rows+1;i++){
            dp[i][0] = 0;
        }
        for(int i = 0;i<cols+1;i++){
            dp[0][i] = 0;
        }
        //base case
        dp[1][1] = 1;

        for(int i = 0; i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(obstacleGrid[i][j] == 1) {
                    dp[i+1][j+1] = 0;
                }else{
                    if(i ==0 && j ==0) {
                        continue;
                    }
                    dp[i+1][j+1] = dp[i][j+1]+dp[i+1][j];
                }
            }
        }

        return dp[rows][cols];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        dp63 obj = new dp63();
        int i = obj.uniquePathsWithObstacles(arr);
        System.out.println(i);
    }

}

