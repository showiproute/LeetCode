import java.util.Stack;

public class stack150 {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Stack<Integer> digits = new Stack<Integer>();
        for(String token : tokens) {
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = digits.pop();
                int b = digits.pop();
                if(token.equals("+")) {
                    int val = a+b;
                    digits.push(val);
                }else if(token.equals("-")) {
                    int val = b-a;
                    digits.push(val);
                }else if(token.equals("*")) {
                    int val = a*b;
                    digits.push(val);
                }else {
                    int val = b/a;
                    digits.push(val);
                }
            }else{
                int val = Integer.parseInt(token);
                digits.push(val);
            }
        }

        return digits.pop();
    }

    public static void main(String[] args) {
        stack150 obj = new stack150();
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int i = obj.evalRPN(tokens);
        System.out.println(i);
    }


}
