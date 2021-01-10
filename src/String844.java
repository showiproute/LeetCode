import java.util.Stack;

public class String844 {

    public boolean backspaceCompare(String S, String T) {
        String s = processStr(S);
        String t = processStr(T);
        return s.equals(t);
    }

    public String processStr(String str){
        if(str == null || str.length() ==0) return "";
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == '#'){
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }else{
                stack.push(str.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
/*
"y#fo##f"
"y#f#o##f"
 */
    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        String844 obj = new String844();
        boolean b = obj.backspaceCompare(s, t);
        System.out.println(b);
    }
}
