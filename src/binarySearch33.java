public class binarySearch33 {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length ==0) return -1;
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = left+(right-left)/2;
            if(nums[mid] == target) return mid;
            if(nums[left] <= nums[mid]) {
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else {
                if(nums[mid] < nums[right]){
                    if(nums[mid] < target && target <= nums[right]){
                        left = mid+1;
                    }else{
                        right = mid-1;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        binarySearch33 obj = new binarySearch33();
        int search = obj.search(nums, 0);
        System.out.println(search);
    }


}
