import java.util.HashMap;

public class prefixSum560 {


    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length ==0) return 0;
        int rst = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);
        int prev = 0;
        for(int i = 0;i<nums.length;i++){
            prev+= nums[i];
            if(hashMap.containsKey(prev-k)){
                rst += hashMap.get(prev-k);
            }
            hashMap.put(prev,hashMap.getOrDefault(prev,0)+1);
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        prefixSum560 obj = new prefixSum560();
        int sum = obj.subarraySum(nums, k);
        System.out.println(sum);
    }
}
