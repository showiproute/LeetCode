import java.util.ArrayList;
import java.util.List;

public class backTracking0809 {

    List<String> rst = new ArrayList<>();
    String target = "()";
    public List<String> generateParenthesis(int n) {
        if(n == 0) return rst;
        backTracking(new StringBuilder(),n);
        return rst;
    }

    public void backTracking(StringBuilder sb,int n) {
        if(sb.length() == n*2) {
            if(isBalanced(sb) == 0) {
                rst.add(sb.toString());
            }
            return;
        }
        for(int i =0 ;i<target.length();i++){
            sb.append(target.charAt(i));
            if(isBalanced(sb) < 0) {
                sb.deleteCharAt(sb.length()-1);
                continue;
            }
            backTracking(sb,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public int isBalanced(StringBuilder sb) {
        int left = 0;
        int right = 0;
        for(int i = 0;i<sb.length();i++){
            if(sb.charAt(i) == '('){
                left++;
            }else{
                right++;
            }
            if(left < right) return -1;
        }

        return left - right;
    }

    public static void main(String[] args) {
        backTracking0809 obj = new backTracking0809();
        List<String> strings = obj.generateParenthesis(3);
        System.out.println(strings.toString());
    }

}
