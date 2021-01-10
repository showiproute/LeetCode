public class tree606 {

    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode t) {
        if(t == null) return "";

        dfs(t);
        return sb.toString();
    }

    public void dfs(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            sb.append(root.val);
        }else if(root.right == null) {
            sb.append(root.val).append("(");
            dfs(root.left);
            sb.append(")");
        }else{
            sb.append(root.val).append("(");
            dfs(root.left);
            sb.append(")(");
            dfs(root.right);
            sb.append(")");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 =new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        root.left=p2;
        root.right=p3;
        p2.right=p4;
        tree606 obj =new tree606();
        String s = obj.tree2str(root);
        System.out.println(s);
    }
}
