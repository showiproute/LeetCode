
public class isBalancedTree {

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        if(Math.abs(left-right) > 1 ) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int treeHeight(TreeNode root) {
        if(root == null) return 0;
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        root.left = p2;
//        root.right=p3;
        p2.left=p4;
//        p3.right=p5;
        isBalancedTree obj = new isBalancedTree();
        boolean balanced = obj.isBalanced(root);
        System.out.println(balanced);
        System.out.println(obj.treeHeight(root));
    }
}

