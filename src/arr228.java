import java.util.ArrayList;
import java.util.List;

public class arr228 {

    //输入：nums = [0,1,2,4,5,7]
    //输出：["0->2","4->5","7"]
    //解释：区间范围是：
    //[0,2] --> "0->2"
    //[4,5] --> "4->5"
    //[7,7] --> "7"
    //
    public List<String> summaryRanges(int[] nums) {
        List<String> rst = new ArrayList<>();
        if(nums == null || nums.length ==0 ) return rst;
        if(nums.length == 1) {
            rst.add(nums[0]+"");
            return rst;
        }
        int start = nums[0];
        int end = start;
        for(int i = 1;i<nums.length;i++){
            if(i == nums.length -1) {
                if(nums[i] == end+1) {
                    rst.add(start+"->"+nums[i]);
                }else{
                    if(start != end) {
                        rst.add(start+"->"+end);
                    }else{
                        rst.add(start+"");
                    }
                    rst.add(nums[i]+"");
                }
                break;
            }
            if(nums[i] == end+1) {
                end = nums[i];
            }else{
                if(start == end) {
                    rst.add(start + "");
                }else{
                    rst.add(start+"->"+end);
                }
                start = nums[i];
                end = start;
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        arr228 obj = new arr228();
        List<String> strings = obj.summaryRanges(nums);
        System.out.println(strings.toString());
    }


}
