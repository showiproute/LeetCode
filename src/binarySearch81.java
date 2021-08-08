public class binarySearch81 {


    public boolean search(int[] nums, int target) {
        int first = binarySearch(nums);
        if(nums[nums.length-1] > target) {
            return binarySearch(nums,first,nums.length-1,target);
        }else{
            return binarySearch(nums,0,first-1,target);
        }
    }

    public int binarySearch(int[] nums) {
        int left =0;
        int right =nums.length-1;
        while (left<=right) {
            int mid = left+ (right-left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1 ;
            }else if(nums[mid] < nums[right]) {
                right = mid;
            }else if(nums[mid] == nums[right]) {
                right = right-1;
            }
        }

        return left;
    }

    public boolean binarySearch(int[] nums,int left,int right,int target) {
        while (left<=right) {
            int mid = left+(right-left)/2;
            if(nums[mid] < target) {
                left = mid + 1;
            }else if(nums[mid] > target) {
                right = mid -1;
            }else if(nums[mid] == target) {
                return true;
            }
        }

        return nums[left] == target;
    }

//[1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1]
//2
    public static void main(String[] args) {
        binarySearch81 obj = new binarySearch81();
        int[] nums = {2,5,6,0,0,1,2};
        boolean search = obj.search(nums, 3);
        System.out.println(search);
    }
}
