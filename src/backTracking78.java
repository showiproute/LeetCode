import java.util.*;

public class backTracking78 {

//    LinkedHashSet<List<Integer>> hashSet = new LinkedHashSet<>();
//    //1,2,3
//    public List<List<Integer>> subsets(int[] nums) {
//        dfs(nums,0,new ArrayList<>());
//        Arrays.sort(nums);
//        return new ArrayList<>(hashSet);
//    }
//
//    public void dfs(int[] nums,int index,List<Integer> tempList) {
//        hashSet.add(new ArrayList<>(tempList));
//        for(int i = index;i<nums.length;i++){
//            tempList.add(nums[i]);
//            dfs(nums,i+1,tempList);
//            tempList.remove(tempList.size()-1);
//        }
//    }

    List<List<Integer>> rst = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return rst;
        }

        Arrays.sort(nums);
        dfs(0,nums,new ArrayList<>());
        return rst;
    }

    public void dfs(int index,int[] nums,ArrayList<Integer> tempList) {
        rst.add(new ArrayList<>(tempList));
        for(int i = index;i<nums.length;i++){
            tempList.add(nums[i]);
            dfs(i+1,nums,tempList);
            tempList.remove(tempList.size()-1);
        }

    }

    public static void main(String[] args) {
        backTracking78 obj = new backTracking78();
        List<List<Integer>> subsets = obj.subsets(new int[]{1,2,3});
        System.out.println(subsets.toString());
    }
}
