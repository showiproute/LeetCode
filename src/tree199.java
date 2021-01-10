import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class tree199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if(root == null) return rst;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode poll = queue.poll();
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null) {
                    queue.offer(poll.right);
                }
                if(i == size-1) {
                    rst.add(poll.val);
                }
            }
        }

        return rst;
    }
}
