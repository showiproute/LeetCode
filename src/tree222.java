public class tree222 {

    public int countNodes(TreeNode root) {
        dfs(root);
        return counts;
    }

    int counts=0;
    public void dfs(TreeNode root) {
        if(root!=null){
            dfs(root.left);
            counts++;
            dfs(root.right);
        }
    }

}
