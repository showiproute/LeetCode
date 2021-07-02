import java.util.Stack;

public class stack1226 {

    //示例 1:
    //
    //输入: "3+2*2"
    //输出: 7
    //示例 2:
    //
    //输入: " 3/2 "
    //输出: 1
    //示例 3:
    //
    //输入: " 3+5 / 2 "
    //输出: 5

    //1+21*3+4*5/6

    //1 21
    //+
    public int calculate(String s) {
        Stack<Character> cal = new Stack<>();
        Stack<Integer> values = new Stack<>();
        for(int i = 0;i<s.length();){
            char ch = s.charAt(i);
            if(ch == ' ') continue;
            if(Character.isDigit(ch)) {
                int nums = 0;
                for(;i<s.length();i++){
                    if(!Character.isDigit(s.charAt(i))) break;
                    nums = nums*10 + s.charAt(i) - '0';
                }
                values.push(nums);
            }else if(ch == '*'){
                int a = 0;
                for(;i<s.length();i++){
                    if(!Character.isDigit(s.charAt(i))) break;
                    a = a*10 + s.charAt(i) - '0';
                }
                Integer b = values.pop();
                values.push(a*b);
            }else if(ch == '/'){
                int a = 0;
                for(;i<s.length();i++){
                    if(!Character.isDigit(s.charAt(i))) break;
                    a = a*10 + s.charAt(i) - '0';
                }
                Integer b = values.pop();
                values.push(a/b);
            }else {
                cal.push(ch);
            }
        }

        while (!cal.isEmpty()) {
            Character ch = cal.pop();
            if(ch == '-' ){
                Integer a = values.pop();
                Integer b = values.pop();
                values.push(b-a);
            }else if(ch == '+'){
                Integer a = values.pop();
                Integer b = values.pop();
                values.push(a+b);
            }
        }


        return 0;
    }

    public int getSum(int i,String s) {
        int nums = 0;
        for(int j = i;j<s.length();j++){
            if(!Character.isDigit(s.charAt(j))) break;
            nums = nums*10 + s.charAt(j) - '0';
        }

        return nums;
    }


}
