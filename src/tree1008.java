public class tree1008 {

    int[] preorder;
    int idx = 0;
    int n ;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length ==0) return null;
        this.preorder = preorder;
        this.n = preorder.length;
        return helper(Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public TreeNode helper(int lower,int upper) {
        if(idx == n) return null;

        int val = preorder[idx];

        if(val < lower || val > upper) return  null;

        idx++;
        TreeNode root = new TreeNode(val);
        root.left = helper(lower,val);
        root.right = helper(val,upper);
        return root;
    }


    public static void main(String[] args) {
        int[] arr = {2,4};
        tree1008 obj = new tree1008();
        TreeNode treeNode = obj.bstFromPreorder(arr);
        System.out.println(treeNode.left.val);
    }


}
