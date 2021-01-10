public class dp746 {

    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length <2){
            return 0;
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i =2;i<cost.length;i++){
            dp[i] = Math.min(dp[i-2]+cost[i],dp[i-1]+cost[i]);
        }

        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        dp746 obj =new dp746();
        int i = obj.minCostClimbingStairs(cost);
        System.out.println(i);
    }
}
