public class ms53 {

    int result;

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length ==1){
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0]= nums[0];
        result = dp[0];
        for(int i = 1;i<nums.length;i++){
            if(dp[i-1] > 0) {
                dp[i] = dp[i-1]+nums[i];
            }else{
                dp[i] = nums[i];
            }
            result = Math.max(result,dp[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {-1,-2};
        ms53 obj = new ms53();
        int i = obj.maxSubArray(array);
        System.out.println(i);
    }

}
