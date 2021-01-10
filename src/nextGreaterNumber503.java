import java.util.Arrays;
import java.util.Stack;

public class nextGreaterNumber503 {

    public int[] nextGreaterElements(int[] nums) {
        int[] rst = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 2*nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i%nums.length]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                rst[i%nums.length] = -1;
            }else{
                rst[i%nums.length] = stack.peek();
            }

            stack.push(nums[i%nums.length]);
        }

        return rst;
    }

    public static void main(String[] args) {
        nextGreaterNumber503 obj = new nextGreaterNumber503();
        int[] ints = obj.nextGreaterElements(new int[]{1, 5,4,1});
        System.out.println(Arrays.toString(ints));


    }
}
