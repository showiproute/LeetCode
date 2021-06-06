import java.util.Arrays;

public class sort31 {

    /*
    1 2 3 4 5 6
    1 2 3 4 6 5
    1 2 3 5 6 4 -> 1 2 3 5 4 6
     */
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length ==0 ) return;
        int left = -1;
        int right = -1;

        for(int i = nums.length-2;i>=0;i--){
            if(nums[i] < nums[i+1]) {
                left = i;
                break;
            }
        }

        if(left == -1) {
            reverse(nums,0,nums.length-1);
        }

        for(int i = nums.length-1;i>=0;i--){
            if(nums[i] > nums[left]) {
                right = i;
                break;
            }
        }

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        reverse(nums,left+1,nums.length-1);
    }

    public void reverse(int[] nums,int left,int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        sort31 obj = new sort31();
        int[] nums = {1,2,2,3,4,3,5,2,2};
        // 1 2 2 3 5 2 3 4
        //                    left        right
        // 1 2 2 3 4 5 5 4 3 3 -> 1 2 2 3 4  3 3 4 5  5
        //        left     right
        obj.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
