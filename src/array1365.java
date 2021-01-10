import java.util.Arrays;

public class array1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        if(nums == null || nums.length ==0 ) return new int[]{};
        int[] rst = new int[nums.length];
        for(int i= 0 ;i<nums.length;i++){
            int counts =0 ;
            for(int j = 0;j<nums.length;j++){
                if(i!=j && nums[i] > nums[j]){
                    counts++;
                }
            }
            rst[i] = counts;
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] arr = {8,1,2,2,3};
        array1365 obj = new array1365();
        int[] ints = obj.smallerNumbersThanCurrent(arr);
        System.out.println(Arrays.toString(ints));
    }
}
