import java.util.Arrays;

public class dp1716 {

    public int massage(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length ==2 ){
            return Math.max(nums[0],nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i =2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length-1];
    }

    public int massagev2(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length ==2 ){
            return Math.max(nums[0],nums[1]);
        }

        int first = nums[0];
        int second = nums[1];
        for(int i =2;i<nums.length;i++) {
            int max = Math.max(first + nums[i], second);
            first =second;
            second =max;
        }
        return second;
    }

    public static void main(String[] args) {
        dp1716 obj = new dp1716();
        int massage = obj.massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3});
        System.out.println(massage);
        int i = obj.massagev2(new int[]{2, 1, 4, 5, 3, 1, 1, 3});
        System.out.println(i);
    }
}
