public class binarySearch287 {


    //二分法做
//    public int findDuplicate(int[] nums) {
//        if(nums == null || nums.length ==0 )return -1;
//        int left = 1;
//        int right = nums.length-1;
//        while(left <= right) {
//            int mid = left+(right-left)/2;
//            int counts = 0;
//            for(int i = 0;i<nums.length;i++){
//                if(nums[i] <= mid) {
//                    counts++;
//                }
//            }
//            if(counts <= mid) {
//                left = mid+1;
//            }else{
//                right = mid-1;
//            }
//        }
//
//        return left;
//    }

    //快慢指针做
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length ==0) return -1;
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow!=fast);

        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,3,4,2};
        binarySearch287 obj = new binarySearch287();
        int duplicate = obj.findDuplicate(arr);
        System.out.println(duplicate);
    }
}
