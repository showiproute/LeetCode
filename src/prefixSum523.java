import java.util.HashMap;

public class prefixSum523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2 ) return false;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1;i<prefixSum.length;i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(prefixSum[0]%k,0);
        for(int i = 1;i<prefixSum.length;i++){
            int key = prefixSum[i] % k;
            if(key == 0 ) return true;
            if(hashMap.containsKey(key)) {
                int val = hashMap.get(key);
                if(i - val >= 2) return true;
            }else{
                hashMap.put(key,i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23,2,6,4,7};
        prefixSum523 obj = new prefixSum523();
        boolean b = obj.checkSubarraySum(nums, 6);
        System.out.println(b);
    }

}
