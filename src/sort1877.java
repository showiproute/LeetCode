import java.util.Arrays;

public class sort1877 {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int minVal = 0;
        int left = 0;
        int right = nums.length-1;
        while (left<right) {
            minVal = Math.max(minVal,nums[left]+nums[right]);
            left++;
            right--;
        }

        return minVal;
    }



}
