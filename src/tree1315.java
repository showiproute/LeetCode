import com.sun.source.tree.Tree;

public class tree1315 {


    public int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return sum;
    }

    public void helper(TreeNode root) {
        if(root !=null){
            if(root.val % 2 ==0) {
                TreeNode left = root.left;
                TreeNode right = root.right;
                if(left!=null) {
                    if(left.left != null) sum+=left.left.val;
                    if(left.right!=null) sum+=left.right.val;
                }
                if(right!=null){
                    if(right.left !=null) sum+=right.left.val;
                    if(right.right!=null) sum+=right.right.val;
                }
            }
            helper(root.left);
            helper(root.right);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode p1 = new TreeNode(7);
        TreeNode p2 = new TreeNode(8);
        TreeNode p3= new TreeNode(2);
        TreeNode p4 = new TreeNode(7);
        TreeNode p5 = new TreeNode(1);
        TreeNode p6 = new TreeNode(3);
        TreeNode p7 = new TreeNode(9);
        TreeNode p8 = new TreeNode(1);
        TreeNode p9 = new TreeNode(4);
        TreeNode p10 = new TreeNode(5);
        root.left =p1;
        root.right=p2;
        p1.left=p3;
        p1.right=p4;
        p2.left=p5;
        p2.right=p6;
        p3.left=p7;
        p4.left=p8;
        p4.right=p9;
        p6.right=p10;

        tree1315 obj = new tree1315();
        int i = obj.sumEvenGrandparent(root);
        System.out.println(i);
    }
}

