import java.util.Arrays;
import java.util.Stack;

public class dp32 {

    //method 1: 暴力解法
//    public int longestValidParentheses(String s) {
//        if(s == null || s.length() ==0 ) return 0;
//        int length = s.length();
//        if(length % 2 !=0 ){
//            length = length-1;
//        }
//        int maxValue = 0;
//        for(int i = length;i>=2;i=i-2){
//            for(int j = 0;j+i<=s.length();j++){
//                String substring = s.substring(j, j + i);
//                if(isValid(substring)) {
//                    maxValue = Math.max(maxValue,i);
//                }
//            }
//        }
//
//        return maxValue;
//    }
//
//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
//        for(int i =0 ;i<s.length();i++){
//            char value = s.charAt(i);
//            if(value == ')') {
//                if(!stack.isEmpty() && stack.peek() == '('){
//                    stack.pop();
//                }else{
//                    return false;
//                }
//            }else{
//                stack.push('(');
//            }
//        }
//
//        return stack.isEmpty();
//    }

    /*
    示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

     */
    //method2： dp
//    public int longestValidParentheses(String s) {
//        if(s == null || s.length() == 0) return 0;
//        int[] dp = new int[s.length()];
//        Arrays.fill(dp,0);
//        //dp[i] 表示 s.charAt(i)为结尾的括号长度
//        int maxValue = 0;
//        for(int i =1 ;i<s.length();i++){
//            if(s.charAt(i) == ')'){
//                if(s.charAt(i-1) == '(') {
//                    dp[i] = (i>=2 ? dp[i-2] : 0) + 2;
//                }else if(i-dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '(') {
//                    dp[i] = dp[i-1] + ((i-dp[i-1]) >=2 ? dp[i-dp[i-1]-2] :0) + 2;
//                }
//            }
//            maxValue = Math.max(maxValue,dp[i]);
//        }
//
//        return maxValue;
//    }

    //method3: stack
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxValue = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '(') {
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }else{
                    maxValue = Math.max(maxValue,i-stack.peek());
                }
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        dp32 obj = new dp32();
        int i = obj.longestValidParentheses("()(())");
        System.out.println(i);

    }

}
