public class stock122 {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length ==0) return 0;
//        int[][] dp = new int[prices.length][2];
        //base
//        dp[0][0] =0;
//        dp[0][1] = -prices[0];
//
//        for(int i = 1;i<prices.length;i++){
//            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
//            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
//        }
//
        int first = 0;
        int second = -prices[0];
        for(int i =1;i<prices.length;i++){
            first = Math.max(first,second+prices[i]);
            second = Math.max(second,first-prices[i]);
        }

        return first;
    }


}
