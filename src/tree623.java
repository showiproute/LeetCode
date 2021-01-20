
public class tree623 {

    public int targetDepth = 0;
    public int val =0;
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        this.targetDepth = d -1;
        this.val = v;
        helper(root,1);
        return root;
    }

    public void helper(TreeNode root,int depth) {
        if(root == null) return;
        if(depth == targetDepth) {
            buildTree(root);
            return;
        }
        if(root.left != null) {
            helper(root.left,depth+1);
        }
        if(root.right != null) {
            helper(root.right,depth+1);
        }

    }

    public void buildTree(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode l = new TreeNode(val);
        TreeNode r = new TreeNode(val);
        root.left = l ;
        root.right  = r;
        l.left = left;
        r.right = right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        TreeNode p3=  new TreeNode(1);
        root.left = p1;
        p1.left=p2;
        p1.right=p3;
        tree623 obj = new tree623();
        TreeNode treeNode = obj.addOneRow(root, 1, 3);
        System.out.println(treeNode.val);
    }
}
