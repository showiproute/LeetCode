import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ms94 {


    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return store;

        inOrder(root);
        return store;
    }

    public  void inOrder(TreeNode root) {
        if(root!=null){
            inOrder(root.left);
            store.add(root.val);
            inOrder(root.right);
        }
    }
    public List<Integer> store = new ArrayList<>();


    //非递归
    public List<Integer> inorderTraversalV2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root!=null) {
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            store.add(root.val);
            root = root.right;
        }

        return store;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode p1 = new TreeNode(1);
        TreeNode p2= new TreeNode(2);
        root.left =p1;
        root.right=p2;

        ms94 obj = new ms94();
        List<Integer> integers = obj.inorderTraversalV2(root);
        System.out.println(integers.toString());
    }
}
