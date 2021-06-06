import java.util.Stack;

public class stack1047 {

    //输入："abbaca"
    //输出："ca"
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i<s.length();i++){
            if(stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
            }else{
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
     //输入："abbaca"
    //输出："ca"
    public static void main(String[] args) {
        stack1047 obj = new stack1047();
        String abbaca = obj.removeDuplicates("abbaca");
        System.out.println(abbaca);
    }
}
