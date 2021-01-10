public class greedy45 {

//    public int jump(int[] nums) {
//        if(nums == null || nums.length ==0) return 0;
//        if(nums.length == 1) return 1;
//        int length = nums.length-1;
//        int index = nums.length-1;
//        int rightRange = length;
//        int counts=0;
//        while(index > 0){
//            for(int i  = index-1;i>=0;i--){
//                if(i+nums[i] >=rightRange) {
//                    index = i;
//                }
//            }
//            rightRange = index;
//            counts++;
//        }
//
//
//        return counts;
//    }


    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0;i<length-1;i++){
            maxPosition = Math.max(maxPosition,i+nums[i]);
            if(i == end) {
                end = maxPosition;
                steps++;
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        int[] arr = {2,1};
        greedy45 obj = new greedy45();
        int jump = obj.jump(arr);
        System.out.println(jump);
    }

}
