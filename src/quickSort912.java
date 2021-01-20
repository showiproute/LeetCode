import java.util.Arrays;

public class quickSort912 {

    //输入：nums = [5,2,3,1]
    //输出：[1,2,3,5]
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums,int left,int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quickSort(nums,left,pivot-1);
            quickSort(nums,pivot+1,right);
        }
    }

    public int partition(int[] nums,int left,int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }

            nums[left] = nums[right];

            while (left < right && nums[left] <= pivot) {
                left++;
            }

            nums[right] = nums[left];
        }

        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        quickSort912 obj = new quickSort912();
        int[] ints = obj.sortArray(nums);
        System.out.println(Arrays.toString(ints));
    }
}
