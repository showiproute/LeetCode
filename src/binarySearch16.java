import java.util.Arrays;

public class binarySearch16 {

    //输入：nums = [-1,2,1,-4], target = 1
    //输出：2
    //解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
    public int threeSumClosest(int[] nums, int target) {
        //-4 -1 1 2
        Arrays.sort(nums);
        int rst = nums[0]+nums[1]+nums[2];
        int distance = Math.abs(nums[0]+nums[1]+nums[2]-target);
        for(int i = 0;i<nums.length-2;i++){
            int val = nums[i];
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                if(Math.abs(nums[left]+nums[right]+val - target) <= distance) {
                    distance = Math.abs(nums[left]+nums[right]+val - target);
                    rst = nums[left]+nums[right]+val;
                }
                if(nums[left]+nums[right]+val - target < 0 ) {
                    left++;
                }else if(nums[left]+nums[right]+val - target > 0){
                    right--;
                }else{
                    return nums[left]+nums[right]+val;
                }
            }
        }


        return rst;
    }

    // [1,2,4,8,16,32,64,128]
    //82
    //-4 -1 1 2
    public static void main(String[] args) {
        int[] nums = {1,2,4,8,16,32,64,128};
        binarySearch16 obj = new binarySearch16();
        int i = obj.threeSumClosest(nums, 82);
        System.out.println(i);
    }


}
