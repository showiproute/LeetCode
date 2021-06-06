public class array665 {

    public boolean checkPossibility(int[] nums) {
        int cnts = 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] >= nums[i-1]) continue;
            cnts++;
            if(i-2 >= 0 && nums[i-2] > nums[i]) {
                nums[i] = nums[i-1];
            }else{
                nums[i-1] = nums[i];
            }
        }

        return cnts<=1;
    }


}
