import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ms15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> store = new ArrayList<>();
        for(int i =0;i<nums.length;i++) {
            if(i >= 1 && nums[i] == nums[i-1]) continue;
            int current = nums[i];
            int j = i+1;
            int k = nums.length-1;
            while(j<k) {
                current+=nums[j];
                current+=nums[k];
                if(current > 0) {
                    k--;
                }else if(current < 0) {
                    j++;
                }else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    store.add(temp);
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]) {
                        j++;
                    }
                    while(j<k && nums[k] == nums[k+1]) {
                        k--;
                    }
                }
                current = nums[i];
            }
        }
        //-2,0,1,1,2

        return store;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        ms15 obj = new ms15();
        List<List<Integer>> lists = obj.threeSum(nums);
        System.out.println(lists.toString());
    }
}