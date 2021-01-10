public class tree1712 {

    public TreeNode convertBiNode(TreeNode root) {
        if(root == null) return root;
        inOrder(root);
        return first;
    }

    TreeNode first = null;
    TreeNode prev = null;

    public void inOrder(TreeNode root) {
        if(root!=null){
            inOrder(root.left);
            if(first == null) {
                first = root;
            }
            if (prev != null) {
                prev.right = root;
                root.left = null;
            }
            prev = root;

            inOrder(root.right);
        }
    }

}
