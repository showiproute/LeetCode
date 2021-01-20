import java.util.HashMap;
import java.util.Map;

public class thoughtworks2 {



    public int tupleSameProduct(int[] nums) {
        if(nums == null || nums.length < 4) return 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i= 0 ;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                hashMap.put(nums[i]*nums[j],hashMap.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }

        int cnts =0 ;
        for(Map.Entry<Integer,Integer> keyValue : hashMap.entrySet()) {
            if(keyValue.getValue() >=2) {
                //c(n,2)
                int n = keyValue.getValue();
                cnts+=n*(n-1)/2;
            }
        }

        return cnts*8;
    }


//    输入：nums = [1,2,4,5,10]
//    输出：16
    //输入：nums = [2,3,4,6,8,12]
    //输出：40
    /*
     */
    public static void main(String[] args) {
        int[] nums = {1,2,4,5,10};
        thoughtworks2 obj = new thoughtworks2();
        int i = obj.tupleSameProduct(nums);
        System.out.println(i);
    }





}
