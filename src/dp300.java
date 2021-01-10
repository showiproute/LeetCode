public class dp300 {

    int maxValue = 1;
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length ==0 )return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i =1;i<nums.length;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    maxValue = Math.max(maxValue,dp[i]);
                }
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        dp300 obj = new dp300();
        int i = obj.lengthOfLIS(arr);
        System.out.println(i);

    }


}
