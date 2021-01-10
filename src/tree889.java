
public class tree889 {

    public int[] pre;
    public int[] post;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre == null || post == null) return null;
        this.pre =pre;
        this.post = post;

        return buildTree(0, pre.length-1, 0, post.length-1);
    }

    public TreeNode buildTree(int pre_left,int pre_end,int post_left,int post_end) {
        if(pre_left < 0 || post_left < 0 || pre_left > pre_end || post_left > post_end) {
            return null;
        }
        if(pre_left == pre_end) return new TreeNode(pre[pre_left]);
        TreeNode root = new TreeNode(pre[pre_left]);
        for(int i = post_left;i<=post_end;i++){
            if(pre_left+1 <= pre_end && post[i] == pre[pre_left+1]){
                int left_count = i-post_left+1;
                root.left =buildTree (pre_left+1,pre_left+left_count,post_left,i);
                root.right = buildTree(pre_left+left_count+1,pre_end,i+1,post_end-1);
            }
         }

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};
        tree889 obj = new tree889();
        TreeNode treeNode = obj.constructFromPrePost(pre, post);
        System.out.println(treeNode.val);

    }
}
