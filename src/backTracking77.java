import java.util.ArrayList;
import java.util.List;

public class backTracking77 {

//    List<List<Integer>> store = new ArrayList<>();
//
//    public List<List<Integer>> combine(int n, int k) {
//        int[] nums = new int[n];
//        for(int i =0;i<n;i++){
//            nums[i] = i+1;
//        }
//
//        dfs(nums,0,k,new ArrayList<>());
//        return store;
//    }
//
//    public void dfs(int[] nums,int index,int k,List<Integer> tempList) {
//        if(tempList.size() == k ){
//            store.add(new ArrayList<>(tempList));
//            return;
//        }
//        for(int i =index;i<nums.length;i++){
//            tempList.add(nums[i]);
//            dfs(nums,i+1,k,tempList);
//            tempList.remove(tempList.size()-1);
//        }
//    }

    List<List<Integer>> rst = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        int[] array = new int[n];
//        for(int i = 0;i<n;i++){
//            array[i] = i+1;
//        }
//        dfs(0,k,array,new ArrayList<>());
        array[0] = 1;
        array[1] = 1;
        array[2] = 2;
        dfsChongfu(0,k,array,new ArrayList<>());
        return rst;
    }

    public void dfs(int index,int k,int[] array,ArrayList<Integer> tempList) {
        if(tempList.size() == k){
            rst.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = index;i<array.length;i++){
            tempList.add(array[i]);
            dfs(i+1,k,array,tempList);
            tempList.remove(tempList.size()-1);
        }
    }

    public void dfsChongfu(int index,int k ,int[] array,ArrayList<Integer> tempList) {
        if(tempList.size() == k) {
            rst.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = index;i<array.length;i++){
            if(i > index && array[i] == array[i-1]) continue;
            tempList.add(array[i]);
            dfs(i+1,k,array,tempList);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        backTracking77 obj = new backTracking77();
        List<List<Integer>> combine = obj.combine(3, 2);
        System.out.println(combine.toString());
    }
}
