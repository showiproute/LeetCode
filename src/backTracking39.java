import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class backTracking39 {

//    List<List<Integer>> rst = new ArrayList<>();
//
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        dfs(candidates,target,0,new ArrayList<>());
//
//        return rst;
//    }
//
//    public void dfs(int[] candidates,int target,int index,ArrayList<Integer> tempList) {
//        if(index == candidates.length) {
//            return;
//        }
//
//        if(target == 0) {
//            rst.add(new ArrayList<>(tempList));
//            return;
//        }
//        //not use
//        dfs(candidates,target,index+1,tempList);
//        //use
//        if(target>= candidates[index]) {
//            tempList.add(candidates[index]);
//            dfs(candidates,target-candidates[index],index,tempList);
//            tempList.remove(tempList.size()-1);
//        }
//    }

    List<List<Integer>> rst = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0,new ArrayList<>());

        return rst;
    }

    public void dfs(int[] candidates,int target,int index,ArrayList<Integer> tempList) {
        if(target == 0) {
            rst.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = index;i<candidates.length;i++){
            tempList.add(candidates[i]);
            if(target - candidates[i] >=0){
                dfs(candidates,target-candidates[i],i,tempList);
            }
            tempList.remove(tempList.size()-1);
        }

    }


    public static void main(String[] args) {
        backTracking39 obj = new backTracking39();
        List<List<Integer>> lists = obj.combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists.toString());
    }
}
