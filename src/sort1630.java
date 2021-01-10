import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sort1630 {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> rst = new ArrayList<>();
        for(int i = 0;i<l.length;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int start = l[i];start<=r[i];start++){
                temp.add(nums[start]);
            }
//            System.out.println(temp.toString());
            if(help(temp)){
                rst.add(true);
            }else{
                rst.add(false);
            }
        }

        return rst;
    }

    public boolean help(ArrayList<Integer> list) {
        if(list.size() == 1) return true;
        Collections.sort(list);
        int dis = list.get(1) - list.get(0);
        for(int i = 1;i<list.size();i++){
            if(list.get(i) - list.get(i-1) != dis) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //输入：nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
        int[] nums = {4,6,5,9,3,7};
        int[] l = {0,0,2};
        int[] r= {2,3,5};
        sort1630 obj = new sort1630();
        List<Boolean> booleans = obj.checkArithmeticSubarrays(nums, l, r);
        System.out.println(booleans.toString());
    }
}
