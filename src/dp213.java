import java.util.Arrays;

public class dp213 {

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        if(nums.length == 3) return Math.max(Math.max(nums[0],nums[1]),nums[2]);

        int a = rob(nums,0,nums.length-1);
        int b=  rob(nums,1,nums.length);
        int c = rob(nums,1,nums.length-1);
        return Math.max(Math.max(a,b),c);
    }

    public int rob(int[] nums,int begin,int end) {
        int[] dp = new int[end-begin];
        dp[0] = nums[begin];
        dp[1] = Math.max(nums[begin],nums[begin+1]);
        int index = 2;
        for(int i = begin+2;i<end;i++){
            dp[index] = Math.max(dp[index-1],dp[index-2]+nums[i]);
            index++;
        }
//        System.out.println(dp[dp.length-1]+":"+begin+end);
//        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        dp213 obj = new dp213();
        int[] nums = {200,3,140,20,10};
        int rob = obj.rob(nums);
        System.out.println(rob);
    }

}