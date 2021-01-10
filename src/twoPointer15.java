import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class twoPointer15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);

        for(int i =0;i<nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int low = i+1;
            int high = nums.length-1;
            while(low<high) {
                if(nums[i]+nums[low]+nums[high] < 0){
                    low++;
                }else if(nums[i]+nums[low]+nums[high] > 0){
                    high--;
                }else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[low]);
                    temp.add(nums[high]);
                    result.add(temp);
                    low++;
                    high--;
                    while( low < high && nums[low] == nums[low-1]){
                        low++;
                    }
                    while(low < high && nums[high] == nums[high+1]){
                        high--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        twoPointer15 obj = new twoPointer15();
        int[] inputNums = {-2,0,1,1,2};
        List<List<Integer>> lists = obj.threeSum(inputNums);
        System.out.println(lists.toString());

        // -4 -1 -1 0 1 2
    }
}
