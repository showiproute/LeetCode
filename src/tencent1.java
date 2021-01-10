import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class tencent1 {

    public static String solution(String origin) {
        if(origin == null || origin.length() == 0) return "";
        Stack<Character> stack_char = new Stack<>();
        for(int i= 0 ;i<origin.length();i++){
            if(origin.charAt(i) !=']'){
                stack_char.push(origin.charAt(i));
            }else{
                StringBuilder digit = new StringBuilder();
                //digit
                while(!stack_char.isEmpty() && stack_char.peek() !='|'){
                    digit.append(stack_char.pop());
                }
                //clear
                stack_char.pop();
                digit = digit.reverse();
                //nums
                StringBuilder nums = new StringBuilder();
                while(!stack_char.isEmpty() && stack_char.peek() !='['){
                    nums.append(stack_char.pop());
                }
                //clear
                stack_char.pop();
                nums = nums.reverse();
                int size = Integer.parseInt(nums+"");
                StringBuilder rst = new StringBuilder();
                for(int j =0;j<size;j++){
                    rst.append(digit);
                }
                //push
                for(int j =0;j<rst.length();j++){
                    stack_char.push(rst.charAt(j));
                }
            }
        }

        StringBuilder sol = new StringBuilder();
        while(!stack_char.isEmpty()) {
            sol.append(stack_char.pop());
        }

        return sol.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String inpuStr = sc.nextLine();
            String solution = solution(inpuStr);
            System.out.println(solution);
        }
    }
}
