import java.util.Arrays;

public class sort31 {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length ==0 )return;
        int left = -1;
        int right = -1;

        for(int i = nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]) {
                left =i;
                break;
            }
        }
        if(left == -1) {
            reverse(0,nums.length-1,nums);
            return;
        }


        for(int i =nums.length-1;i>left;i--){
            if(nums[i] > nums[left]){
                right = i;
                break;
            }
        }

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

        reverse(left+1,nums.length-1,nums);
    }

    public void reverse(int left,int right,int[] nums) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        sort31 obj = new sort31();
        int[] nums = {1,2,2,3,3,5,5,4,4,3};
        obj.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
