public class ms543 {

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        dfs(root);

        return maxValue;
    }

    int maxValue = Integer.MIN_VALUE;

    public int dfs(TreeNode root) {
        if(root == null) return 0;

        int left =dfs(root.left);
        int right = dfs(root.right);
        maxValue = Math.max(maxValue,left+right);

        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        root.left = p2;
        root.right=p3;
        p2.left=p4;
        p2.right=p5;
        ms543 obj = new ms543();
        int i = obj.diameterOfBinaryTree(root);
        System.out.println(i);
    }

}
