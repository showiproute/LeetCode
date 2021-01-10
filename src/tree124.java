public class tree124 {

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root);

        return maxValue;
    }

    public int maxValue = 0;

    public int dfs(TreeNode root) {
        if(root !=null){
            int left = Math.max(dfs(root.left),0);
            int right = Math.max(dfs(root.right),0);

            maxValue = Math.max(left+right+root.val,maxValue);

            root.val += Math.max(left,right);
            return root.val;
        }else{
            return 0;
        }
    }
}