public class tree112 {

    public boolean found = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return found;
    }

    public void dfs(TreeNode root,int sum) {
        if(root == null) return;
        if(root.val == sum && root.left ==null && root.right ==null) {
            found = true;
            return;
        }
        dfs(root.left,sum-root.val);
        dfs(root.right,sum-root.val);
    }

}


