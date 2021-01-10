import java.util.Arrays;

public class array189 {

    //输入: [1,2,3,4,5,6,7] 和 k = 3
    //输出: [5,6,7,1,2,3,4]
    //解释:
    //向右旋转 1 步: [7,1,2,3,4,5,6]
    //向右旋转 2 步: [6,7,1,2,3,4,5]
    //向右旋转 3 步: [5,6,7,1,2,3,4]

    //o(n) o(n)
//    public void rotate(int[] nums, int k) {
//        if(k == 0 || nums.length == 0) return;
//        int length = nums.length;
//        int[] temp = new int[length];
//        for(int i= 0;i<length;i++){
//            int index = (k+i)%length;
//            temp[index] = nums[i];
//        }
//        for(int i = 0 ;i<length;i++){
//            nums[i] = temp[i];
//        }
//        return;
//    }

    //o(n) o(1)
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k ==0) return;
        int length = nums.length;
        reverse(nums,0,length-1);
        reverse(nums,0,k%length-1);
        reverse(nums,k%length,length-1);
    }

    public void reverse(int[] nums,int start,int end) {
        while(start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        array189 obj = new array189();
        int[] nums = {1,2,3,4,5,6,7};
        obj.rotate(nums,2);
        System.out.println(Arrays.toString(nums));
    }


}
