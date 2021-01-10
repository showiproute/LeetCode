import java.util.LinkedList;
import java.util.Queue;

public class bfs111 {


    //1: bfs
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode poll = queue.poll();
                if(poll.left != null) {
                    queue.offer(poll.left);
                }
                if(poll.right != null) {
                    queue.offer(poll.right);
                }
                if(poll.left == null && poll.right == null) {
                    return depth;
                }
            }
            depth++;
        }

        return depth;
    }


    //2: dfs
    public int minDepthv2(TreeNode root) {
        if(root == null) return 0;
        dfs(root,1);
        return minValue;
    }

    int minValue = Integer.MAX_VALUE;

    public void dfs(TreeNode root,int depth) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            minValue = Math.min(minValue,depth);
        }

        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p9 = new TreeNode(9);
        TreeNode p20 = new TreeNode(20);
        TreeNode p15 = new TreeNode(15);
        TreeNode p7 = new TreeNode(7);
        root.left = p9;
        root.right=p20;
        p20.left=p15;
        p20.right=p7;
        bfs111 obj = new bfs111();
        int i = obj.minDepthv2(root);
        System.out.println(i);

    }


}
