public class dp674 {


    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        //base
        dp[0] = 1;
        int maxLength = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] > nums[i-1]) {
                dp[i] = dp[i-1]+1;
                maxLength = Math.max(maxLength,dp[i]);
            }else{
                dp[i] = 1;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        dp674 obj = new dp674();
        int lengthOfLCIS = obj.findLengthOfLCIS(nums);
        System.out.println(lengthOfLCIS);

    }

}
