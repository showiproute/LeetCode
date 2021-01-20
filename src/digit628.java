import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class digit628 {

    //-50 1 2 -100 -200
    //-50 -100 -200  1 2
    public int maximumProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int len = nums.length;
        int a = nums[0]*nums[1]*nums[len-1];
        int b = nums[len-3]*nums[len-2]*nums[len-1];
        return Math.max(a,b);
    }


}
