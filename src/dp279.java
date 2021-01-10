import java.util.Arrays;

public class dp279 {

    public int numSquares(int n) {
        if(n <=3) return n;
        int[] dp = new int[n+1];
        int length = (int)Math.sqrt(n);
        int[] nums = new int[length];
        for(int i = 0;i<length;i++){
            nums[i] = (int)Math.pow(i+1,2);
        }
        Arrays.fill(dp,Integer.MAX_VALUE);
        //base case
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3;i<=n;i++){
            for(Integer num : nums) {
                if(i-num <0){
                    break;
                }else{
                    dp[i] = Math.min(dp[i],dp[i-num]+1);
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        dp279 obj = new dp279();
        int i = obj.numSquares(13);
        System.out.println(i);
    }
}
