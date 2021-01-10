public class tree55_2 {

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        if(Math.abs(left-right) > 1) {
            return false;
        }
        boolean l = isBalanced(root.left);
        boolean r = isBalanced(root.right);
        return l && r;
    }

    public int depth(TreeNode root) {
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);

        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {

    }

}
