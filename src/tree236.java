public class tree236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;

        dfs(root,p,q);
        return target;
    }

    public TreeNode target = null;

    public boolean dfs(TreeNode root,TreeNode p,TreeNode q) {
        if(root == null ) return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);

        if((left && right) || ((left || right) && (root == p || root == q))){
            target = root;
            return true;
        }

        return left || right || root == p || root == q;
    }



}