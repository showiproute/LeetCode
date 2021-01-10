import java.util.Arrays;

public class dp416 {

    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int sum  =0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;

        int N = nums.length;
        int W = sum/2;
        boolean[][] dp =new boolean[N+1][W+1];
        //base case
        for(int i = 0;i<=N;i++){
            dp[i][0] = true;
        }
        for(int i = 0;i<=W;i++){
            dp[0][i] = false;
        }

        for(int i = 1;i<=N;i++){
            for(int j =1;j<=W;j++){
                if(j-nums[i-1] < 0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

//        //test
//        for(int i = 0;i<dp.length;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        return dp[N][W];
    }

    //状态压缩 TODO

    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        dp416 obj = new dp416();
        boolean b = obj.canPartition(arr);
        System.out.println(b);
    }
}

