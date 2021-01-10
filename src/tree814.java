import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class tree814 {

    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        return helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if(root!=null){
            TreeNode left = helper(root.left);
            TreeNode right = helper(root.right);
            if(root.val == 0 && left == null && right == null){
                return null;
            }
            root.left = left;
            root.right = right;
            return root;
        }else{
            return null;
        }
    }

    public void print(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                list.add(node.val);
            }
            System.out.println(list.toString());
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p1 = new TreeNode(0);
        TreeNode p2 = new TreeNode(1);
        TreeNode p3 = new TreeNode(0);
        TreeNode p4 =new TreeNode(0);
        TreeNode p5 = new TreeNode(0);
        TreeNode p6 = new TreeNode(1);
        root.left = p1;
        root.right = p2;
        p1.left =p3;
        p1.right=p4;
        p2.left=p5;
        p2.right=p6;
        tree814 obj = new tree814();
        TreeNode treeNode = obj.pruneTree(root);
        obj.print(treeNode);
    }

}
