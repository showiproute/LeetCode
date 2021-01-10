import java.util.Arrays;

public class binarySearch34 {

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0 ) return new int[]{-1,-1};

        int left = leftSearch(nums,target);
        int right = rightSearch(nums,target);
        int[] rst = new int[2];
        rst[0] = left;
        rst[1] = right;
        return rst;
    }

    public int leftSearch(int[] nums,int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = left+(right-left)/2;
            if(nums[mid] > target) {
                right = mid-1;
            }else if(nums[mid] < target) {
                left = mid+1;
            }else if(nums[mid] == target){
                right = mid-1;
            }
        }

        if(left < 0 || left >= nums.length || nums[left] != target) {
            return -1;
        }

        return left;
    }

    public int rightSearch(int[] nums,int target) {
        int left =0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = left+(right-left)/2;
            if (nums[mid] < target) {
                left = mid+1;
            }else if(nums[mid] > target) {
                right = mid-1;
            }else if(nums[mid] == target) {
                left = mid+1;
            }
        }

        if(right < 0  ||  right >= nums.length  || nums[right] != target) {
            return -1;
        }

        return right;
    }


    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        binarySearch34 obj = new binarySearch34();
        int[] ints = obj.searchRange(nums, 8);
        System.out.println(Arrays.toString(ints));
    }
}
