import java.util.*;

public class array5618 {

    public int maxOperations(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i =0 ;i<nums.length;i++){
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }
        int counts= 0 ;
        for(Map.Entry<Integer,Integer> keyValue : hashMap.entrySet()) {
            Integer key = keyValue.getKey();
            Integer value = keyValue.getValue();
            while(value > 0) {
                value--;
                hashMap.put(key,hashMap.get(key)-1);
                if(hashMap.containsKey(k-key)) {
                    if(hashMap.get(k-key) > 0) {
                        if(k-key == key) {
                            value--;
                        }
                        counts++;
                        hashMap.put(k-key,hashMap.get(k-key) -1);
                    }
                }
            }
        }

        return counts;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,3,3,4};
        array5618 obj = new array5618();
        int i = obj.maxOperations(nums, 6);
        System.out.println(i);
    }
}
