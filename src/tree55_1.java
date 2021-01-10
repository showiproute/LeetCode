public class tree55_1 {

    //自下而上
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left,right)+1;
    }

    //自上而下
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        helper(root,1);
        return maxValue;
    }

    int maxValue = 0;

    public void helper(TreeNode root,int depth) {
        if(root ==  null) return;

        if(root.left == null && root.right == null) {
            maxValue = Math.max(maxValue,depth);
        }

        helper(root.left,depth+1);
        helper(root.right,depth+1);
    }

}