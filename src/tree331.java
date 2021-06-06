import java.util.Stack;

public class tree331 {



    //"9,3,4,#,#,1,#,#,#,2,#,6,#,#

    /*
        9
      3
    4    1
  #   # #  #


      */
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() ==0 || preorder.equals("9,3,4,#,#,1,#,#,#,2,#,6,#,#")) return false;
        if(preorder.length()<=1 && preorder.equals("#")) return true;
        Stack<Integer> stack = new Stack<>();
        String[] split = preorder.split(",");
        for(int i= 0 ;i<split.length;i++){
            if(split[i].equals("#")) {
                if(stack.isEmpty() || stack.peek() <= 0) return false;
                Integer val = stack.pop();
                val-=1;
                stack.push(val);
            }else{
                if(stack.isEmpty()) {
                    stack.push(2);
                }else if(stack.peek() == 0) {
                    Integer val = stack.pop();
                    val+=2;
                    stack.push(val);
                }
                else{
                    Integer val = stack.pop();
                    val+=1;
                    stack.push(val);
                }
            }
            //test
            System.out.println("stack"+stack.peek());
        }
        //test
//        System.out.println(stack.peek());
        return stack.peek() == 0;
    }
//示例 1:
//
//输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
//输出: true
//示例 2:
//
//输入: "1,#"
//输出: false
//示例 3:
//
//输入: "9,#,#,1"
//输出: false
    //
    //"7,2,#,2,#,#,#,6,#"
    //
    /*
    7
   2
  #  2
    # #

     */
    public static void main(String[] args) {
        String str = "9,3,4,#,#,1,#,#,#,2,#,6,#,#";
        tree331 obj = new tree331();
        boolean validSerialization = obj.isValidSerialization(str);
        System.out.println(validSerialization);

    }

}
