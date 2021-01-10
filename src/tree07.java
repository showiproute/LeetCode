import java.util.HashMap;

public class tree07 {


    public int[] preOrder;
    public int[] inOrder;
    public HashMap<Integer,Integer> inIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length ==0 || inorder == null || inorder.length ==0) return null;
        this.preOrder = preorder;
        this.inOrder = inorder;

        for(int i = 0;i<inorder.length;i++){
            inIndexMap.put(inorder[i],i);
        }

        return build(0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int pre_left,int pre_right,int in_left,int in_right) {
        if(pre_left < 0 || pre_left > pre_right || in_left < 0 || in_left > in_right) return null;
        TreeNode root = new TreeNode(preOrder[pre_left]);
        int leftSize = inIndexMap.get(root.val)-in_left;
        root.left = build(pre_left+1,pre_left+leftSize,in_left,in_left+leftSize);
        root.right = build(pre_left+leftSize+1,pre_right,in_left+leftSize+1,in_right);
        return root;
    }
    /*
    前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
     */
}