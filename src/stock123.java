public class stock123 {

    public int maxProfit(int[] prices) {
        int k = 2;
        int[][][] dp = new int[prices.length][k + 1][2];//标准三维dp
        for (int i = 0; i < prices.length; i++) {
            dp[i][0][0] = 0;
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }
}
