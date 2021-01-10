import java.util.Arrays;

public class stock121 {

    /*
    dp[-1][k][0] = dp[i][0][0] = 0;
    dp[-1][k][1] = dp[i][0][1] = -inf

    dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
    dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
     */

    /*
    k == 1
    dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i]);
    dp[i][1] = max(dp[i-1][1],dp[i-1][0]-prices[i]);

     */
    public int maxProfit(int[] profit) {
        if(profit == null || profit.length ==0 ) return 0;
        int[][] dp = new int[profit.length][2];
        dp[0][0] = 0;
        dp[0][1] = -profit[0];

        for(int i =1;i<profit.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+profit[i]);
            dp[i][1] = Math.max(dp[i-1][1],-profit[i]);
        }

        return dp[profit.length-1][0];
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        stock121 obj =  new stock121();
        int i = obj.maxProfit(arr);
        System.out.println(i);
    }
}
