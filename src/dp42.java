public class dp42 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for(int i = 1;i<nums.length;i++) {
            if(dp[i-1] > 0 ){
                dp[i] = dp[i-1]+nums[i];
            }else{
                dp[i] = nums[i];
            }
        }

        int maxValue = Integer.MIN_VALUE;
        for(int i =0;i<dp.length;i++){
            if(dp[i] > maxValue) {
                maxValue = dp[i];
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        dp42 obj = new dp42();
        int i = obj.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }

}
