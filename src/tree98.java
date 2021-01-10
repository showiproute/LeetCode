public class tree98 {

    public boolean isValidBST(TreeNode root) {
        if(root == null) return false;
        return dfs(root);
    }

    public boolean dfs(TreeNode root) {
        if(root != null) {
            if(root.left != null && root.left.val > root.val) return false;
            if(root.right != null && root.right.val < root.val) return false;
            boolean left = dfs(root.left);
            boolean right = dfs(root.right);
            return left && right;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode p2 = new TreeNode(1);
        TreeNode p3 = new TreeNode(3);
        root.left = p2;
        root.right = p3;
        tree98 obj = new tree98();
        boolean validBST = obj.isValidBST(root);
        System.out.println(validBST);
    }

}