//    public static int binarySearch(int[] nums,int target) {
//        if(nums == null || nums.length ==0){
//            return -1;
//        }
//        int low = 0;
//        int high = nums.length-1;
//        while(low <= high) {
//            int mid = (low+high) /2;
//            if(nums[mid] == target) {
//                return mid;
//            }else if(nums[mid] > target) {
//                high = mid-1;
//            }else{
//                low = mid+1;
//            }
//        }
//
//        return -1;
//    }
//
//    public static int[] findTarget(int[] nums,int target) {
//        int[] rst = {-1,-1};
//
//        if(nums == null || nums.length ==0){
//            return rst;
//        }
//
//        int index = binarySearch(nums,target);
//        if(index == -1){
//            return rst;
//        }
//        int low = index-1;
//        while(low >= 0 && nums[low] == target) {
//            low--;
//        }
//        rst[0] = low+1;
//        int high = index+1;
//        while(high < nums.length && nums[high] == target) {
//            high++;
//        }
//        rst[1] = high-1;
//
//        return rst;
//
//    }