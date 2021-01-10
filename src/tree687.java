public class tree687 {

    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return ans;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int length_left = 0,length_right = 0;
        if(root.left != null && root.left.val == root.val) {
            length_left += left+1;
        }
        if(root.right != null && root.right.val == root.val) {
            length_right +=right+1;
        }
        ans = Math.max(ans,length_left+length_right);
        return Math.max(length_left,length_right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p1 = new TreeNode(1);
        TreeNode p2= new TreeNode(1);
        TreeNode p3=  new TreeNode(1);
        TreeNode p4= new TreeNode(1);
        TreeNode p5 = new TreeNode(1);
        TreeNode p6 = new TreeNode(1);
        root.right =p1;
        p1.right=p2;
        p2.right=p3;
        p3.right=p4;
        p4.right=p5;
        p5.right=p6;
        tree687 obj = new tree687();
        int i = obj.longestUnivaluePath(root);
        System.out.println(i);
    }

}
