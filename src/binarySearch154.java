public class binarySearch154 {

//    public int findMin(int[] nums) {
//        if(nums == null || nums.length ==0) return -1;
//        int left = 0;
//        int right = nums.length-1;
//        while(left<=right) {
//            int mid = left+(right-left)/2;
//            if(nums[mid] > nums[right]) {
//                left = mid+1;
//            }else if(nums[mid] < nums[right]) {
//                right = mid-1;
//            }else if(nums[mid] == nums[right]) {
//                right = right-1;
//            }
//        }
//
//        return nums[left];
//    }

    public int findMin(int[] nums) {
        if(nums == null || nums.length ==0) return -1;
        int left = 0;
        int right = nums.length-1;
        while(left<=right) {
            int mid = left+(right-left)/2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }else if(nums[mid] == nums[right]) {
                right = right-1;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
            /*
    输入: [4,5,6,7,0,1,2]
输出: 0
     */
        int[] arr = {4,5,6,1,1,1,2};
        binarySearch154 obj = new binarySearch154();
        int min = obj.findMin(arr);
        System.out.println(min);
    }

}
