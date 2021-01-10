import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class twoSum18 {

    //-2 -1 0 0 1 2
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        if(nums == null) return rst;
        Arrays.sort(nums);
        for(int i =0;i<nums.length;i++){
            if(i >0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1;j<nums.length-1;j++){
                if(j > i+1&& nums[j] == nums[j-1] ) continue;
                int left = j+1;
                int right = nums.length-1;
                while(left < right) {
                    if(nums[i]+nums[j]+nums[left]+nums[right] > target) {
                        right--;
                    }else if (nums[i]+nums[j]+nums[left]+nums[right] < target){
                        left++;
                    }else{
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        System.out.println(temp.toString());
                        rst.add(temp);
                        while(left < right && nums[left] == nums[left+1]) left++;
                        left++;
                        while(left < right && nums[right-1] == nums[right]) right--;
                        right--;
                    }
                }
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
        twoSum18 obj = new twoSum18();
        List<List<Integer>> lists = obj.fourSum(nums, -9);
        System.out.println(lists.toString());
    }


}
