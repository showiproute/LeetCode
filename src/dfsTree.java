public class dfsTree {


    public void sumTreeDepths(TreeNode root,int depth) {
        if(root!=null) {
            dfs(root,depth);
            sumTreeDepths(root.left,depth);
            sumTreeDepths(root.right,depth);
        }
    }

    public int ans;

    public void dfs(TreeNode root,int depth) {
        ans+=depth;
        if(root.left != null) {
            dfs(root.left,depth+1);
        }
        if(root.right != null) {
            dfs(root.right,depth+1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        TreeNode p6 = new TreeNode(6);
        TreeNode p7 = new TreeNode(7);
        TreeNode p8 = new TreeNode(8);
        TreeNode p9 = new TreeNode(9);
        root.left = p2;
        root.right = p3;
        p2.left=p4;
        p2.right =p5;
        p3.left = p6;
        p3.right = p7;
        p4.left = p8;
        p4.right = p9;
        dfsTree obj = new dfsTree();
        obj.sumTreeDepths(root,0);
        System.out.println(obj.ans);
    }
}
