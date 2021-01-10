import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class backTracking40 {

    List<List<Integer>> rst = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        dfs(candidates,target,0,new ArrayList<>());

        return rst;
    }

    public void dfs(int[] candidates,int target,int index,ArrayList<Integer> tempList) {
        if(target == 0){
            rst.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = index;i<candidates.length;i++){
            if( i > index && candidates[i] == candidates[i-1] ) {
                continue;
            }
            tempList.add(candidates[i]);
            if(target - candidates[i] >=0 ){
                dfs(candidates,target-candidates[i],i+1,tempList);
            }
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        backTracking40 obj = new backTracking40();
//        int[] inputNums = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
//        Arrays.sort(inputNums);
//        System.out.println(Arrays.toString(inputNums));
        int[] inputNums = {10,1,2,7,6,1,5};
        List<List<Integer>> lists = obj.combinationSum2(inputNums, 8);
        System.out.println(lists.toString());
    }
}
