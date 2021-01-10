public class ms236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p ==null || q==null) return root;

        dfs(root,p,q);

        return target;
    }

    public TreeNode target;

    public boolean dfs(TreeNode root,TreeNode p ,TreeNode q) {
        if(root == null) return false;
        boolean lchild = dfs(root.left, p, q);
        boolean rchild = dfs(root.right, p, q);

        if((lchild && rchild) || ((root == p || root ==q) && (lchild || rchild))){
            target = root;
        }

        return lchild || rchild || root ==p || root ==q;
    }



}
