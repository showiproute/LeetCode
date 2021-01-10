public class tree0408 {

    public TreeNode target=  null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return target;
        dfs(root,p,q);
        return target;
    }

    public boolean dfs(TreeNode root,TreeNode p,TreeNode q) {
        if(root == null  || p == null || q == null) return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if((left&&right) || ( (root == p || root ==q) && (left || right))){
            target = root;
            return true;
        }

        return root == p || root == q || left || right;
    }


}
