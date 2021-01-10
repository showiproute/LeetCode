import java.util.ArrayList;
import java.util.Arrays;

public class backTracking377 {

    ArrayList<ArrayList<Integer>> rst = new ArrayList<>();
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);

        dfs(0,target,nums,new ArrayList<>());
        return rst.size();
    }

    public void dfs(int index, int target, int[] nums, ArrayList<Integer> tempList) {
        if(target == 0 ){
            rst.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = index;i<nums.length;i++){
            tempList.add(nums[i]);
            if(target-nums[i] >=0){
                dfs(index,target-nums[i],nums,tempList);
            }
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        backTracking377 obj = new backTracking377();
        int i = obj.combinationSum4(new int[]{1,2,3}, 4);
        System.out.println(i);
        System.out.println(obj.rst.toString());
    }

}
