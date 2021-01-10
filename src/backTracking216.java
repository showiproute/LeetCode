import java.util.ArrayList;
import java.util.List;

public class backTracking216 {

//    List<List<Integer>> rst = new ArrayList<>();
//
//    public List<List<Integer>> combinationSum3(int k, int n) {
//        int[] nums = new int[9];
//        for(int i =0;i<nums.length;i++){
//            nums[i] = i+1;
//        }
//
//        dfs(k,n,0,nums,new ArrayList<>());
//        return rst;
//    }
//
//    public void dfs(int k,int n,int index,int[] nums,List<Integer> tempList) {
//        if(tempList.size() == k) {
//            int sum = 0;
//            for(int i =0;i<tempList.size();i++){
//                sum+=tempList.get(i);
//            }
//            if(sum == n) {
//                rst.add(new ArrayList<>(tempList));
//            }
//            return;
//        }
//        for(int i =index;i<nums.length;i++){
//            tempList.add(nums[i]);
//            dfs(k,n,i+1,nums,tempList);
//            tempList.remove(tempList.size()-1);
//        }
//    }


    List<List<Integer>> rst = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
       int[] array = new int[9];
       for(int i = 0;i<9;i++){
           array[i] = i+1;
       }

       dfs(0,array,n,k,new ArrayList<>());
       return rst;
    }
    public void dfs(int index,int[] array,int target,int k,ArrayList<Integer> tempList) {
        if(tempList.size() == k) {
            if(target == 0 ){
                rst.add(new ArrayList<>(tempList));
            }
            return;
        }

        for(int i = index;i<array.length;i++){
            tempList.add(array[i]);
            if(target-array[i] >=0 ){
                dfs(i+1,array,target-array[i],k,tempList);
            }
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        backTracking216 obj = new backTracking216();
        List<List<Integer>> lists = obj.combinationSum3(3, 7);
        System.out.println(lists.toString());
    }
}
