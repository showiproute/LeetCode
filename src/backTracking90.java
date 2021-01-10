import java.util.*;

public class backTracking90 {

//    List<List<Integer>> rst = new ArrayList<>();
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        Arrays.sort(nums);
//        dfs(nums,0,new ArrayList<>());
//
//        return rst;
//    }
//
//    public void dfs(int[] nums,int index,ArrayList<Integer> tempList) {
//        rst.add(new ArrayList<>(tempList));
//        for(int i= index;i<nums.length;i++){
//            if(i > index && nums[i] == nums[i-1]) {
//                System.out.println("i,nums[i],nums[i-1]"+i+nums[i]+nums[i-1]);
//                continue;
//            }
//            tempList.add(nums[i]);
//            System.out.println("tempList:"+tempList.toString());
//            dfs(nums,i+1,tempList);
//            tempList.remove(tempList.size()-1);
//        }
//    }

    List<List<Integer>> rst = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0){
            return rst;
        }

        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<>());
        return rst;
    }

    public void dfs(int[] nums,int index,ArrayList<Integer> tempList) {
        rst.add(new ArrayList<>(tempList));
        for(int i = index;i<nums.length;i++){
            if( i > index && nums[i] == nums[i-1]){
                continue;
            }
            tempList.add(nums[i]);
            dfs(nums,i+1,tempList);
            tempList.remove(tempList.size()-1);
        }
    }


    public static void main(String[] args) {
        backTracking90 obj = new backTracking90();
        List<List<Integer>> lists = obj.subsetsWithDup(new int[]{4,4,4,1,4});
        System.out.println(lists.toString());
    }
}
