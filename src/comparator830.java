import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class comparator830 {

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> rst = new ArrayList<>();
        if(s == null || s.length() == 0) return rst;
        int left = 0;
        int right = 1;
        while (right < s.length()) {
            if(s.charAt(right) != s.charAt(left)) {
                if(right - left >=3) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(left);
                    temp.add(right-1);
                    rst.add(temp);
                }
                left = right;
                right = left+1;
            }else{
                right++;
            }
        }
        if(right == s.length() && left != right-1 && s.charAt(right-1) == s.charAt(left) ) {
            if(right - left >=3) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(left);
                temp.add(right-1);
                rst.add(temp);
            }
        }
        Collections.sort(rst, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0)-o2.get(0);
            }
        });

        return rst;
    }

    //输入：s = "abcdddeeeeaabbbcd"
    //输出：[[3,5],[6,9],[12,14]]
    public static void main(String[] args) {
        comparator830 obj = new comparator830();
        List<List<Integer>> rst = obj.largeGroupPositions("aaa");
        System.out.println(rst);
    }
}
