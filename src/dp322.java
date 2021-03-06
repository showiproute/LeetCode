import java.util.Arrays;

public class dp322 {

    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length ==0 )return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;

        for(int i = 1;i<=amount;i++){
            for(Integer coin : coins) {
                if(coin <=i){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }

        return dp[amount] == amount+1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        dp322 obj = new dp322();
        int[] coins = {1,2,3};
        int i = obj.coinChange(coins, 5);
        System.out.println(i);
    }


}
