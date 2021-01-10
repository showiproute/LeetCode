import java.util.HashSet;

public class hash41 {

    //暴力破解
//    public int firstMissingPositive(int[] nums) {
//        if(nums == null || nums.length == 0 ) return 1;
//        HashSet<Integer> hashSet = new HashSet<>();
//        for(int i = 0;i<nums.length;i++){
//            if(nums[i]>0){
//                hashSet.add(nums[i]);
//            }
//        }
//
//        int rst = 1;
//        while(true) {
//            if(hashSet.contains(rst)) {
//                rst++;
//            }else{
//                break;
//            }
//        }
//
//        return rst;
//    }

    //原地hash
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;

        //nums[nums[i]-1] == nums[i]
        //原地置换
        for(int i = 0;i<nums.length;i++){
            while(nums[i] - 1 >= 0 && nums[i]-1 < nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums,i,nums[i]-1);
            }
        }

        for(int i = 0;i<nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }

        return nums.length+1;
    }

    public void swap(int[]nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7,8,9,11,12};
        hash41 obj = new hash41();
        int i = obj.firstMissingPositive(arr);
        System.out.println(i);
    }


}
