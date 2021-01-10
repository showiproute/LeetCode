import java.util.HashMap;

public class tree105 {

    public HashMap<Integer,Integer> inMap = new HashMap<>();
    public int[] preorder;
    public int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;

        for(int i = 0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }

        this.preorder = preorder;
        this.inorder = inorder;

        return buildTree(0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode buildTree(int pre_left,int pre_right,int in_left,int in_right) {
        if(pre_left > pre_right) return null;
        TreeNode root = new TreeNode(preorder[pre_left]) ;

        int index = inMap.get(preorder[pre_left]);
        int leftSize = index-in_left;

        root.left = buildTree(pre_left+1,pre_left+leftSize,in_left,index-1);
        root.right = buildTree(pre_left+leftSize+1,pre_right,index+1,in_right);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        tree105 obj = new tree105();
        TreeNode treeNode = obj.buildTree(preorder, inorder);
        System.out.println(treeNode.val);
    }
}
