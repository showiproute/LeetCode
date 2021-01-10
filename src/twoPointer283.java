import java.util.Arrays;

public class twoPointer283 {

    /*
    输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
     */
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;

        for(int i = 0;i<nums.length;i++){
            if(nums[i] != 0) {
                continue;
            }
            for(int j = i+1;j<nums.length;j++){
                if(nums[j] !=0) {
                    swap(nums,i,j);
                    break;
                }
            }
        }
    }

    public void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        twoPointer283 obj = new twoPointer283();
        int[] nums = {0,0,0,0,0};
        obj.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
