import java.util.Arrays;
import java.util.HashMap;

public class hash645 {

    //输入：nums = [1,2,2,4]
    //输出：[2,3]
    //[2,2] [2,1]
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer,Integer> hashMap =new HashMap<>();
        int n = nums.length;
        int[] rst = new int[2];
        for(int num : nums) {
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }
        for(int i = 1 ;i<=n;i++){
            int val = hashMap.getOrDefault(i, 0);
            if(val == 2) {
                rst[0] = i;
            }else if(val == 0) {
                rst[1] = i;
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,3};
        hash645 obj = new hash645();
        int[] errorNums = obj.findErrorNums(nums);
        System.out.println(Arrays.toString(errorNums));
    }
}
