import java.util.Stack;

public class tree1028 {


    public TreeNode recoverFromPreorder(String S) {
        if(S == null || S.length() ==0) return null;

        Stack<TreeNode> stack = new Stack<>();
        for(int i=0;i<S.length();){
            int level = 0;
            while(i<S.length() && S.charAt(i) == '-'){
                i++;
                level++;
            }
            int val = 0;
            while(i<S.length() && S.charAt(i) !='-'){
                val=val*10+Integer.parseInt(S.charAt(i)+"");
                i++;
            }
            TreeNode node = new TreeNode(val);

            while(stack.size() > level) {
                stack.pop();
            }

            if(!stack.isEmpty()){
                if(stack.peek().left == null){
                    stack.peek().left = node;
                }else{
                    stack.peek().right = node;
                }
            }

            stack.add(node);
        }

        int size = stack.size();
        for(int i = 0;i<size-1;i++){
            stack.pop();
        }

        return stack.pop();
    }

    //输入："1-401--349---90--88""
    //输出：[1,2,5,3,4,6,7]

     /*
        1
      401
     349 88
    90

     */

    public static void main(String[] args) {
        String s = "1-401--349---90--88";
        tree1028 obj = new tree1028();
        TreeNode treeNode = obj.recoverFromPreorder(s);
        System.out.println(treeNode.left.val);
    }
}

