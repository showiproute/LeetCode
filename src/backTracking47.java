import java.util.*;

public class backTracking47 {


    List<List<Integer>> rst = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length ==0 ){
            return rst;
        }

        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums,visited,new ArrayList<>());
        return rst;
    }

    public void backTracking(int[] nums,boolean[] visited,ArrayList<Integer> tempList) {
        if(tempList.size() == nums.length) {
            rst.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1] && !visited[i-1]) {
                continue;
            }
            if(!visited[i]){
                visited[i] = true;
                tempList.add(nums[i]);
                backTracking(nums,visited,tempList);
                visited[i] = false;
                tempList.remove(tempList.size()-1);
            }
        }

    }


    public static void main(String[] args) {
        backTracking47 obj = new backTracking47();
        int[] inputNums = {1,2,2};
        List<List<Integer>> lists = obj.permuteUnique(inputNums);
        System.out.println(lists.toString());
    }

}
