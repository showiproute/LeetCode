import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;

public class greedy330 {

    /*
    输入: nums = [1,3], n = 6
输出: 1
解释:
根据 nums 里现有的组合 [1], [3], [1,3]，可以得出 1, 3, 4。
现在如果我们将 2 添加到 nums 中， 组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
其和可以表示数字 1, 2, 3, 4, 5, 6，能够覆盖 [1, 6] 区间里所有的数。
所以我们最少需要添加一个数字。

     1,3   n = 6

     1 3 4

     1,3  4  (4 + 4 + 1)]

     1,total  1+nums[k],total+nums[k]   nums[k]
     => 1,total  nums[k],total+nums[k]

     case 1: nums[k] <= total + 1

     case 2: nums[k] > total + 1
     */
    public int minPatches(int[] nums, int n) {
        long totals = 0;
        int cnts = 0;
        int index =0;

        while(totals < n) {
            if(index < nums.length && nums[index] <= totals + 1) {
                totals+=nums[index++];
            }else{
                totals <<= 1;
                cnts++;
            }
        }

        return cnts;
    }

    public static void main(String[] args) {
        greedy330 obj = new greedy330();
        int i = obj.minPatches(new int[]{1,2,31,33}, 2147483647);
        System.out.println(i);
    }
}
