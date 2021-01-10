import java.util.HashMap;

public class offer07 {

    public int[] preorder;
    public int[] inorder;
    public HashMap<Integer,Integer> hashMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length ==0) {
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;
        for(int i = 0;i<inorder.length;i++){
            hashMap.put(inorder[i],i);
        }

        return build(0, preorder.length - 1, 0, inorder.length - 1);
    }


    public TreeNode build(int pre_left,int pre_right,int in_left,int in_right) {
        if(pre_left > pre_right || in_left > in_right) return null;
        TreeNode root = new TreeNode(preorder[pre_left]);
        int index = hashMap.get(root.val);
        int leftSize = index-in_left;
        root.left = build(pre_left+1,pre_left+leftSize,in_left,in_left+leftSize);
        root.right = build(pre_left+leftSize+1,pre_right,index+1,in_right);
        return root;
    }


}
