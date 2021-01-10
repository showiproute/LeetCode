public class twoPointer209 {
//  前缀和
//    public int minSubArrayLen(int s, int[] nums) {
//        if(nums == null || nums.length == 0) return -1;
//        int ans = Integer.MAX_VALUE;
//        int[] sums = new int[nums.length+1];
//        for(int i =1;i<=nums.length;i++){
//            sums[i] = sums[i-1]+nums[i-1];
//        }
//        for(int i = 1;i<=nums.length;i++){
//            int target = s + sums[i-1];
//            int bound = Arrays.binarySearch(sums,target);
//            if(bound < 0) {
//                bound = -bound-1;
//            }
//            if(bound <= nums.length){
//                ans = Math.min(ans,bound-(i-1));
//            }
//        }
//        return ans == Integer.MAX_VALUE ? 0 : ans;
//    }

    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length ==0 ) return 0;
        int left = 0;
        int right = 0;
        int rst = Integer.MAX_VALUE;
        int sum = 0;
        while(right < nums.length){
            sum+=nums[right];
            while(sum >= s){
                rst = Math.min(rst,right-left+1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return rst == Integer.MAX_VALUE ? 0 : rst;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        twoPointer209 obj = new twoPointer209();
        int i = obj.minSubArrayLen(7, nums);
        System.out.println(i);
    }
}
