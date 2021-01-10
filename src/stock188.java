public class stock188 {

    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2)
            return k_inf(prices);
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

    public int k_inf(int[] prices) {
        // int dp_i_0 = 0 , dp_i_1 = Integer.MIN_VALUE;//动态规划
        // for(int i = 0 ; i< prices.length ; i++){
        //     int tmp = dp_i_0;
        //     dp_i_0 = Math.max(dp_i_0 , dp_i_1 + prices[i]);
        //     dp_i_1 = Math.max(dp_i_1 , tmp - prices[i]);
        // }
        // return dp_i_0;
        int max = 0;/////贪心
        for(int i = 1 ; i< prices.length ; i++){
            if(prices[i] > prices[i-1])
                max += prices[i]-prices[i-1];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,6,5,0,3};
        stock188 obj = new stock188();
        int i = obj.maxProfit(2, arr);
        System.out.println(i);
    }
}
