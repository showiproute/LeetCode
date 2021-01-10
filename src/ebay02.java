import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class ebay02 {

    public static boolean solution(String str) {
        if(str == null || str.length()%2!=0) return false;
        if(str.equals("")) return true;
        HashMap<Character,Character> hashMap = new HashMap<>();
        //init
        hashMap.put('(',')');
        hashMap.put('{','}');
        hashMap.put('[',']');
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(hashMap.containsKey(ch)) {
                stack.push(ch);
            }else if(!stack.isEmpty() && hashMap.get(stack.peek()) == ch){
                stack.pop();
            }else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int T = sc.nextInt();
            sc.nextLine();
            for(int i =0;i<T;i++){
                String s = sc.nextLine();
                if(solution(s)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }
    }
}
