
public class tree68_1 {

//    public TreeNode target = null;
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root == null || p == null || q==null) return null;
//        dfs(root,p,q);
//        return target;
//    }
//
//    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
//        if(root == null || p == null || q==null) return false;
//        boolean left = dfs(root.left, p, q);
//        boolean right = dfs(root.right, p, q);
//        if( (left && right) || ((root.val==p.val || root.val == q.val) && (left || right ))){
//            target = root;
//            return true;
//        }
//
//        return root.val ==p.val || root.val == q.val || left || right;
//    }
    /*
    6
    2 8
    0 4 7 9
      3 5
     */

    public TreeNode target;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;
        boolean dfs = dfs(root, p, q);
        return target;
    }

    public boolean dfs(TreeNode root,TreeNode p,TreeNode q) {
        if(root == null || p == null || q == null) return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if( (left && right) || (root == p || root == q) &&(left || right)) {
            target = root;
            return true;
        }

        return root ==p || root == q|| left || right;
    }


    public static void main(String[] args) {
        TreeNode root= new TreeNode(6);
        TreeNode p2= new TreeNode(2);
        TreeNode p8 = new TreeNode(8);
        TreeNode p0 = new TreeNode(0);
        TreeNode p4 = new TreeNode(4);
        TreeNode p7 = new TreeNode(7);
        TreeNode p9 = new TreeNode(9);
        TreeNode p3 = new TreeNode(3);
        TreeNode p5= new TreeNode(5);
        root.left =p2;
        root.right=p8;
        p2.left=p0;
        p2.right=p4;
        p8.left=p7;
        p8.right = p9;
        p4.left =p3;
        p4.right=p5;
        tree68_1 obj =new tree68_1();
        TreeNode treeNode = obj.lowestCommonAncestor(root, p2, p7);
        System.out.println(treeNode.val);
    }

}