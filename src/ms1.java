import java.util.Arrays;
import java.util.HashMap;

public class ms1 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for(int i =0;i<nums.length;i++) {
            if (hashmap.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = hashmap.get(target - nums[i]);
                return result;
            } else {
                hashmap.put(nums[i], i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ms1 obj = new ms1();
        int[] ints = obj.twoSum(new int[]{3,2,4}, 6);
        System.out.println(Arrays.toString(ints));
    }

}
