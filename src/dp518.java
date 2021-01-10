public class dp518 {

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
        int[] arr = {3};
        dp518 obj = new dp518();
        int change = obj.change(2, arr);
        System.out.println(change);
    }
}
