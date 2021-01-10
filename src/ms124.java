public class ms124 {

    public int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;

        dfs(root);
        return maxValue;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;

        int left = Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);

        maxValue = Math.max(maxValue,left+right+root.val);

        return root.val+Math.max(left,right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        TreeNode p9 = new TreeNode(9);
        TreeNode p20 = new TreeNode(20);
        TreeNode p15 = new TreeNode(15);
        TreeNode p7 = new TreeNode(7);
        root.left = p9;
        root.right = p20;
        p20.left=p15;
        p20.right=p7;

        ms124 obj = new ms124();
        int sum = obj.maxPathSum(root);
        System.out.println(sum);
    }
}
