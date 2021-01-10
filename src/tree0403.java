import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class tree0403 {

    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null) return new ListNode[]{};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left !=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                temp.add(node.val);
            }
            list.add(temp);
            temp = new ArrayList<>();
        }
        ListNode[] rst = new ListNode[list.size()];
        for(int i = 0;i<list.size();i++){
            ArrayList<Integer> arrayList = list.get(i);
            ListNode head = new ListNode(-1);
            ListNode p = head;
            for (Integer integer : arrayList) {
                ListNode node = new ListNode(integer);
                p.next = node;
                p = node;
            }
            rst[i] = head.next;
        }

        return rst;
    }
}
