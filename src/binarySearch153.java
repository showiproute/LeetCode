public class binarySearch153 {
//    public int[] array;
//    public int first;
//    public int targetIndex;
//    public int findMin(int[] nums) {
//        if(nums == null || nums.length ==0) return -1;
//        array = nums;
//        first=nums[0];
//
//        binarySearch(0,nums.length-1);
//        return array[targetIndex];
//    }
//
//    public void binarySearch(int left,int right) {
//        if(left>right || left<0 || right>=array.length) return;
//        int mid = left+(right-left)/2;
//        if(array[mid] >= first) {
//            if(mid+1 < array.length && array[mid+1] < first) {
//                targetIndex = mid+1;
//                return;
//            }
//            binarySearch(mid+1,right);
//        }else if(array[mid] < first) {
//            binarySearch(left,mid-1);
//        }
//    }

    //normal
//    public int findMin(int[] nums) {
//        if(nums == null || nums.length == 0 ) return -1;
//        int left = 0;
//        int right = nums.length-1;
//        while(left <= right) {
//            int mid = left+(right-left)/2;
//            if(nums[mid] > nums[nums.length-1]){
//                left = mid +1;
//            }else if(nums[mid] <= nums[nums.length-1]){
//                right = mid-1;
//            }
//        }
//
//        return nums[left];
//    }

    //递归
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        return binarySearch(nums, 0, nums.length-1);
    }

    public int binarySearch(int[] nums,int left,int right) {
        if(left > right) return Math.min(left == nums.length ? Integer.MAX_VALUE: nums[left],right == -1? Integer.MAX_VALUE:nums[right]);
        int mid  = left+(right-left)/2;
        if(nums[mid] < nums[right]) {
            return binarySearch(nums,left,mid);
        }else{
            return binarySearch(nums,mid+1,right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2};
        binarySearch153 obj = new binarySearch153();
        int min = obj.findMin(arr);
        System.out.println(min);
    }

}