public class ms700 {

    public TreeNode target;

    public TreeNode searchBST(TreeNode root, int val) {
        dfs(root,val);
        return target;
    }


    public void dfs(TreeNode root,int val) {
        if(root == null) return;
        if(root.val == val) {
            target = root;
            return;
        }
        dfs(root.left,val);
        dfs(root.right,val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode p2 = new TreeNode(2);
        TreeNode p7 = new TreeNode(7);
        TreeNode p1=  new TreeNode(1);
        TreeNode p3 = new TreeNode(3);
        root.left = p2;
        root.right=p7;
        p2.left = p1;
        p2.right=p3;
        ms700 obj = new ms700();
        TreeNode treeNode = obj.searchBST(root, 2);
        System.out.println(treeNode.val);
    }
}
