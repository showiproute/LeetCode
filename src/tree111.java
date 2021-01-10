public class tree111 {

    int minValue = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null ) return 0;

        dfs(root,1);
        return minValue;
    }

    public void dfs(TreeNode root,int depth) {
        if(root != null){
            if(root.left == null && root.right == null){
                minValue = Math.min(minValue,depth);
            }
            dfs(root.left,depth+1);
            dfs(root.right,depth+1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p9 = new TreeNode(9);
        TreeNode p20 = new TreeNode(20);
        TreeNode p15 = new TreeNode(15);
        TreeNode p7 = new TreeNode(7);
        root.left = p9;
        root.right = p20;
        p20.left=p15;
        p20.right=p7;
        tree111 obj = new tree111();
        int i = obj.minDepth(root);
        System.out.println(i);
    }
}

