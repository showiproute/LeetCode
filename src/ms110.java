public class ms110 {

    public  boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        dfs(root);

        return isBalanced;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(Math.abs(left-right) > 1)  isBalanced = false;

        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {



    }
}
