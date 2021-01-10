import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class backTracking46 {

//    List<List<Integer>> store=  new ArrayList<>();
//    //1 2 3
//    public List<List<Integer>> permute(int[] nums) {
//        dfs(nums,0);
//        return store;
//    }
//
//    public void dfs(int[] nums,int index) {
//        if(index == nums.length-1) {
//            List<Integer> temp = new ArrayList<>();
//            for(int i =0;i<nums.length;i++){
//                temp.add(nums[i]);
//            }
//            store.add(temp);
//            return;
//        }
//        for(int i = index;i<nums.length;i++){
//            swap(nums,i,index);
//            dfs(nums,index+1);
//            swap(nums,i,index);
//        }
//    }
//
//    public void swap(int[] nums,int i,int j){
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }

    List<List<Integer>> rst = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return rst;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums,visited,new ArrayList<>());

        return rst;
    }

    public void dfs(int[] nums,boolean[] visited,ArrayList<Integer> tempList) {
        if(tempList.size() == nums.length) {
            rst.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(!visited[i]) {
                visited[i] = true;
                tempList.add(nums[i]);
                dfs(nums,visited,tempList);
                tempList.remove(tempList.size()-1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        backTracking46 obj = new backTracking46();
        int[] inputNums = {1,2,3};
        List<List<Integer>> permute = obj.permute(inputNums);
        System.out.println(permute.toString());
    }

}
