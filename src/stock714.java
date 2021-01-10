public class stock714 {
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length ==0) return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0]-fee;
        for(int i =1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]-fee);
        }

        return dp[prices.length-1][0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 8, 4, 9};
        stock714 obj = new stock714();
        int i = obj.maxProfit(arr, 2);
        System.out.println(i);
    }
}
