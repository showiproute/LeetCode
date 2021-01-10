import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class hash448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        if(nums == null || nums.length ==0 ) return rst;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            hashSet.add(nums[i]);
        }

        for(int i =1;i<=nums.length;i++){
            if(!hashSet.contains(i)){
                rst.add(i);
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        hash448 obj = new hash448();
        List<Integer> disappearedNumbers = obj.findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers.toString());
    }
}
