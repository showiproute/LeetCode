import java.util.Arrays;

public class arrayMs {

    //判断一个数组是否是大约排好序的数组，也就是下面两个条件满足一个
    //1. 交换任意两个数字，得到的是一个排好序的 比如 [1, 5, 3, 4, 2]
    //2. 数组中的一段子序列旋转后能是一个排好序的数组，比如[1,2, 7,6,5,4,3, 8,9]

    public boolean solution(int[] nums) {
        int[] temp = Arrays.copyOfRange(nums, 0, nums.length);
        return swapNums(nums) || reverseNums(temp);
    }

    public boolean swapNums(int[] nums) {
        int[] temp = new int[nums.length];
        temp = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(nums);
        int counts = 0 ;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != temp[i]) {
                counts++;
            }
        }
        return counts == 2;
    }

    public boolean reverseNums(int[] nums) {
        int begin = -1;
        int end = -1;
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]) {
                begin = i;
                break;
            }
        }

        if(begin == -1) return true;

        for(int i = begin;i<nums.length-1;i++){
            if(nums[i] < nums[i+1]) {
                end = i;
                break;
            }
        }
        end = end == -1 ? nums.length-1:end;
        while(begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }

        for(int i =0 ;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int[] arr = {5,4,2,3};
        arrayMs obj = new arrayMs();
        boolean solution = obj.solution(arr);
        System.out.println(solution);
    }
}
