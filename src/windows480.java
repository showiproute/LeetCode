import java.util.Arrays;

public class windows480 {


    public double[] medianSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = k-1;
        double[] rst = new double[nums.length-k+1];
        for(;right<nums.length;right++){
            long[] arr = new long[k];
            int i = 0;
            for(int j = left;j<=right;j++){
                arr[i] = nums[j];
                i++;
            }
            Arrays.sort(arr);
            if(k % 2 == 0) {
                double v = (arr[k / 2 - 1] + arr[k / 2]) / 2.0;
                rst[left] = v;
            }else{
                rst[left] = arr[k/2];
            }
            left++;
        }

        return rst;
    }

//给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
    // 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]
    //[2147483647,2147483647]
    public static void main(String[] args) {
        int[] nums = {2147483647,2147483647};
        windows480 obj = new windows480();
        double[] doubles = obj.medianSlidingWindow(nums, 2);
        System.out.println(Arrays.toString(doubles));
    }
}
