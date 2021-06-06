public class array1848 {

    /*
    示例 1：

输入：nums = [1,2,3,4,5], target = 5, start = 3
输出：1
解释：nums[4] = 5 是唯一一个等于 target 的值，所以答案是 abs(4 - 3) = 1 。
示例 2：

输入：nums = [1], target = 1, start = 0
输出：0
解释：nums[0] = 1 是唯一一个等于 target 的值，所以答案是 abs(0 - 0) = 1 。
示例 3：

输入：nums = [1,1,1,1,1,1,1,1,1,1], target = 1, start = 0
输出：0
解释：nums 中的每个值都是 1 ，但 nums[0] 使 abs(i - start) 的结果得以最小化，所以答案是 abs(0 - 0) = 0 。
     */
    public int getMinDistance(int[] nums, int target, int start) {
        int minVal = Integer.MAX_VALUE;
        for(int i =0 ;i<nums.length;i++){
            if(nums[i] == target) {
                minVal = Math.min(minVal,Math.abs(i-start));
            }
        }

        return minVal;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 5;
        int start = 3;
        array1848 obj = new array1848();
        int minDistance = obj.getMinDistance(nums, target, start);
        System.out.println(minDistance);
    }

}
