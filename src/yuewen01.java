public class yuewen01 {

    public TreeNode nearestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        // write code here
        if(root == null || p == null || q == null) return null;
        helper(root,p,q);
        return target;
    }

    public TreeNode target = null;

    public boolean helper(TreeNode root,TreeNode p ,TreeNode q) {
        if(root == null || p == null || q == null) return false;
        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);

        if((left && right) || ((root.val == p.val || root.val ==q.val) && (left || right))){
            target = root;
            return true;
        }

        return root.val == p.val || root.val == q.val || left || right;
    }

}
