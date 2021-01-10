import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ms662 {

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        q.offer(root);
        list.add(1);
        int res = 1;
        while(!q.isEmpty()) {
            int count = q.size();
            for(int i = count;i>0;i--){
                TreeNode cur = q.poll();
                Integer curIndex = list.removeFirst();
                if(cur.left != null){
                    q.offer(cur.left);
                    list.add(curIndex*2);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                    list.add(curIndex*2+1);
                }
            }
            if(list.size()>=2) {
                res = Math.max(res,list.getLast()-list.getFirst()+1);
            }
        }

        return res;
    }

}
