import java.util.ArrayList;
import java.util.List;

public class backTracking22 {

    //暴力破解法 需要剪枝
//    List<String> rst =  new ArrayList<>();
//    public List<String> generateParenthesis(int n) {
//        if(n <=0 ) return rst;
//        dfs(n*2,new StringBuilder(),new char[]{'(',')'});
//        return rst;
//    }
//
//    public void dfs(int depth,StringBuilder sb,char[] arr){
//        if(sb.length() == depth) {
//            if(isValid(sb)){
//                rst.add(sb.toString());
//            }
//        }else{
//            for(int i =0 ;i<arr.length;i++){
//                sb.append(arr[i]);
//                dfs(depth,sb,arr);
//                sb.deleteCharAt(sb.length()-1);
//            }
//        }
//    }
//
//    public boolean isValid(StringBuilder sb){
//        int balances = 0;
//        for(int i = 0;i<sb.length();i++){
//            if(sb.charAt(i) == '('){
//                balances++;
//            }else{
//                balances--;
//            }
//            if(balances<0){
//                return false;
//            }
//        }
//
//        return balances == 0;
//    }

    //回溯法
//    List<String> rst = new ArrayList<>();
//    public List<String> generateParenthesis(int n) {
//        backTracking(n,n,new StringBuilder());
//        return rst;
//    }
//
//    public void backTracking(int left,int right,StringBuilder sb){
//        if(left == 0 && right == 0) {
//            rst.add(sb.toString());
//            return;
//        }
//        if(left > 0 ){
//            sb.append("(");
//            backTracking(left-1,right,sb);
//            sb.deleteCharAt(sb.length()-1);
//        }
//        if(right > left) {
//            sb.append(")");
//            backTracking(left,right-1,sb);
//            sb.deleteCharAt(sb.length()-1);
//        }
//    }

    List<String> rst = new ArrayList<>();
    public List<String> generateParenthesis(int n){
        if(n<=0) return rst;
        backTracking(n,n,new StringBuilder());
        return rst;
    }

    public void backTracking(int left,int right,StringBuilder sb){
        if(left == 0 && right == 0) {
            rst.add(sb.toString());
            return;
        }
        if(left>0) {
            sb.append("(");
            backTracking(left-1,right,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right>left) {
            sb.append(")");
            backTracking(left,right-1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public static void main(String[] args) {
        backTracking22 obj = new backTracking22();
        List<String> strings = obj.generateParenthesis(3);
        System.out.println(strings.toString());
    }
}
