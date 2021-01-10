import java.util.HashMap;

public class tree106 {

    HashMap<Integer,Integer> inMap = new HashMap<>();
    public int[] inorder;
    public int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length ==0) return null;
        this.inorder = inorder;
        this.postorder = postorder;
        for(int i = 0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        return buildTree(0,inorder.length-1,0,postorder.length-1);
    }

    public TreeNode buildTree(int in_left,int in_right,int post_left,int post_right) {
        if(post_left > post_right) return null;
        TreeNode root = new TreeNode(postorder[post_right]);
        int index = inMap.get(postorder[post_right]);

        int leftSize = index-in_left;
        root.left = buildTree(in_left,index-1,post_left,post_left+leftSize-1);
        root.right = buildTree(index+1,in_right,post_left+leftSize,post_right-1);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        tree106 obj = new tree106();
        TreeNode treeNode = obj.buildTree(inorder, postorder);
        System.out.println(treeNode.val);
    }

}
