public class dp303 {

    class NumArray {
        public int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for(int k =i;k<=j;k++){
                sum+=nums[k];
            }
            return sum;
        }
    }
}
