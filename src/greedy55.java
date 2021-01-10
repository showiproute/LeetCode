public class greedy55 {

    public boolean canJump(int[] nums) {
        if(nums == null || nums.length ==0 )return false;
        int length = nums.length;
        int rightRange = 0;
        for(int i = 0;i<nums.length;i++){
            if(i<=rightRange) {
                rightRange = Math.max(rightRange,nums[i]+i);
                if(rightRange>=length-1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,0};
        greedy55 obj = new greedy55();
        boolean b = obj.canJump(arr);
        System.out.println(b);
    }
}
