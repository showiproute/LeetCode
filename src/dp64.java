import java.util.Arrays;

public class dp64 {

    public int minPathSum(int[][] grid) {
        if(grid == null || grid[0] == null) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        //init
        for(int i = 1;i<grid[0].length;i++){
            dp[0][i] = grid[0][i]+dp[0][i-1];
        }
        for(int i=1;i<grid.length;i++){
            dp[i][0] = grid[i][0]+dp[i-1][0];
        }


        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

//        for(int i = 0;i<grid.length;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] array = {
                {1,2,5},
                {3,2,1},
        };
        dp64 obj =new dp64();
        int sum = obj.minPathSum(array);
        System.out.println(sum);
    }
}
