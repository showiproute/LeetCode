import java.util.Arrays;
import java.util.HashMap;

public class dp673 {

    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length ==0 )return 0;
        int[] dp = new int[nums.length];
        int[] counter = new int[nums.length];
        //init base
        Arrays.fill(dp,1);
        Arrays.fill(counter,1);

        int max = 1;
        for(int i=1;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i]){
                    if(dp[j] +1 > dp[i]){
                        dp[i] = dp[j]+1;
                        counter[i] = counter[j];
                    }else if(dp[j]+1 == dp[i]){
                        counter[i] +=counter[j];
                    }
                }
            }
            max = Math.max(max,dp[i]);
        }

//        System.out.println(Arrays.toString(dp));
//        System.out.println(Arrays.toString(counter));

        int counts= 0;
        for(int i= 0 ;i<dp.length;i++){
            if(dp[i] == max) {
                counts+=counter[i];
            }
        }

        return counts;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2};
        dp673 obj = new dp673();
        int numberOfLIS = obj.findNumberOfLIS(arr);
        System.out.println(numberOfLIS);
    }
}
