import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class hash442 {

    //暴力
//    public List<Integer> findDuplicates(int[] nums) {
//        List<Integer> rst = new ArrayList<>();
//        if(nums == null || nums.length ==0 ) return rst;
//        HashSet<Integer> hashSet = new HashSet<>();
//        for(int i =0 ;i<nums.length;i++){
//            if(hashSet.contains(nums[i])){
//                rst.add(nums[i]);
//            }else{
//                hashSet.add(nums[i]);
//            }
//        }
//
//        return rst;
//    }

    //原地数组hash
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        if(nums == null || nums.length ==0 ) return rst;
        //原地置换
        for(int i =0;i<nums.length;i++){
            while(nums[i]-1 >=0 && nums[i]-1 < nums.length) {
                if(nums[nums[i]-1] != nums[i]) {
                    swap(nums,i,nums[i]-1);
                }else {
                    if(i != nums[i]-1){
                        rst.add(nums[nums[i]-1]);
                        nums[i] = 0;
                    }
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(nums));

        return rst;
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        hash442 obj = new hash442();
        List<Integer> duplicates = obj.findDuplicates(arr);
        System.out.println(duplicates.toString());

    }
}

