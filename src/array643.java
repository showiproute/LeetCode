public class array643 {

    public double findMaxAverage(int[] nums, int k) {
        int maxVal = 0;
        int sum = 0;
        for(int  i = 0;i<k;i++){
            sum+=nums[i];
        }
        maxVal = sum;

        for(int j = k;j<nums.length;j++){
            sum = sum-nums[j-k]+nums[j];
            maxVal = Math.max(maxVal,sum);
        }

        return maxVal/(double)k;
    }

    //输入：[1,12,-5,-6,50,3], k = 4
    //输出：12.75
    //解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        array643 obj = new array643();
        double maxAverage = obj.findMaxAverage(nums, 4);
        System.out.println(maxAverage);
    }
}
