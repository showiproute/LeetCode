import java.util.Arrays;

public class stock309 {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length ==0) return 0;
        if(prices.length < 2) return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0],dp[0][1]+prices[1]);
        dp[1][1] = Math.max(-prices[0],-prices[1]);

        for(int i =2;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }

        return dp[prices.length-1][0];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,0,2};
        stock309 obj = new stock309();
        int i = obj.maxProfit(arr);
        System.out.println(i);
    }
}
