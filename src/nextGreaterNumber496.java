import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class nextGreaterNumber496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = nums2.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                map.put(nums2[i],-1);
            }else{
                map.put(nums2[i],stack.peek());
            }

            stack.push(nums2[i]);
        }

        int[] rst = new int[nums1.length];
        for(int i = 0;i<nums1.length;i++){
            rst[i] = map.get(nums1[i]);
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        nextGreaterNumber496 obj = new nextGreaterNumber496();
        int[] ints = obj.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }


}
