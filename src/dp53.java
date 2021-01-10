public class dp53 {

    //solution1 贪心
    public int maxSubArrayV1(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        int sum  = nums[0];
        int maxValue = Integer.MIN_VALUE;
        for(int  i=0;i<nums.length;i++){
            if(sum > 0){
                sum+=nums[i];
            }else{
                sum=nums[i];
            }
            maxValue = Integer.max(maxValue,sum);
        }

        return maxValue;
    }

    //solution2 dp
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length ==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i =1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }

        int maxValues = dp[0];
        for(int i =0;i<dp.length;i++){
            if(dp[i]>maxValues) {
                maxValues = dp[i];
            }
        }

        return maxValues;
    }

    public static void main(String[] args) {
        int[] array =new int[]{-2,1,-3,4,-1,2,1,-5,4};
        dp53 obj = new dp53();
        int i = obj.maxSubArray(array);
        System.out.println(i);
    }


}
