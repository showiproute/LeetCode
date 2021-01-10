import java.util.Arrays;

public class sort581 {

    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length ==0) return 0;

        int[] temp = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(temp);
        int start = 0;
        int end= nums.length-1;
        while(start<nums.length) {
            if(temp[start] != nums[start]){
                break;
            }
            start++;
        }
        while(end>=0){
            if(temp[end] != nums[end]) {
                break;
            }
            end--;
        }

        if(start<end) {
            return end-start+1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] arr ={5,4,2};
        sort581 obj = new sort581();
        int unsortedSubarray = obj.findUnsortedSubarray(arr);
        System.out.println(unsortedSubarray);
    }
}
