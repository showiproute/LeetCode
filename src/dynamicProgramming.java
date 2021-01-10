import java.util.Arrays;

public class dynamicProgramming {

    //0-1背包问题
    /*
    N = 3 ,W = 4
    wt = {2,1,3}
    val = {4,2,3}
     */
    public int oneZeroPacket(int[] wt,int[] val,int N,int W){
        int[][] dp = new int[N+1][W+1];
        //base case
        for(int i = 0;i<=W;i++){
            dp[0][i] = 0;
        }
        for(int i =0;i<=N;i++){
            dp[i][0] = 0;
        }

        for(int i = 1;i<=N;i++){
            for(int j =1;j<=W;j++){
                if(j-wt[i-1] < 0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1]);
                }
            }
        }

        //test
        for(int i = 0;i<dp.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[N][W];
    }

    //子集背包问题
    //dp416
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int sum  =0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;

        int N = nums.length;
        int W = sum/2;
        boolean[][] dp =new boolean[N+1][W+1];
        //base case
        for(int i = 0;i<=N;i++){
            dp[i][0] = true;
        }
        for(int i = 0;i<=W;i++){
            dp[0][i] = false;
        }

        for(int i = 1;i<=N;i++){
            for(int j =1;j<=W;j++){
                if(j-nums[i-1] < 0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

//        //test
//        for(int i = 0;i<dp.length;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        return dp[N][W];
    }

    //完全背包问题
    public int change(int amount, int[] coins) {
        if(coins.length == 0 && amount ==0) return 1;
        int[][] dp = new int[coins.length+1][amount+1];
        //base case
        for(int i = 0;i<=coins.length;i++){
            dp[i][0] = 1;
        }
        for(int i =0 ;i<=amount;i++) {
            dp[0][i] = 0;
        }

        for(int i = 1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j-coins[i-1] < 0) {
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int[] wt = {2,1,3};
        int[] val = {4,2,3};
        int N = 3;
        int W = 4;
        dynamicProgramming obj = new dynamicProgramming();
        int i = obj.oneZeroPacket(wt, val, N, W);
        System.out.println(i);
    }

}
