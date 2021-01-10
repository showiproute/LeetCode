import java.util.*;

public class backTracking491 {

    HashSet<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums,0,new ArrayList<>());

        return new ArrayList<>(result);
    }

    public void backTracking(int[] nums,int index,List<Integer> rst) {
        if(rst.size() >=2){
            List<Integer> temp = new ArrayList<>(rst);
            result.add(temp);
        }
        for(int i =index;i<nums.length;i++){
            if((!rst.isEmpty() && nums[i] < rst.get(rst.size()-1))){
                continue;
            }
            rst.add(nums[i]);
            backTracking(nums,i+1,rst);
            rst.remove(rst.size()-1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        backTracking491 obj = new backTracking491();
        List<List<Integer>> subsequences = obj.findSubsequences(nums);
        System.out.println(subsequences.toString());
    }
}
