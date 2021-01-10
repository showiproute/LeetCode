import java.util.ArrayList;
import java.util.List;

public class backTracking0804 {


    /*
     输入： nums = [1,2,3]
 输出：
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

     */

    public List<List<Integer>> store = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }

        dfs(nums,new ArrayList<>(),0);
        return store;
    }

    public void dfs(int[] nums,List<Integer> tempList,int index) {
        store.add(new ArrayList<>(tempList));
        for(int i = index;i<nums.length;i++){
            tempList.add(nums[i]);
            dfs(nums,tempList,i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        backTracking0804 obj = new backTracking0804();
        List<List<Integer>> subsets = obj.subsets(new int[]{1, 2, 3});
        System.out.println(subsets.toString());
    }

}
