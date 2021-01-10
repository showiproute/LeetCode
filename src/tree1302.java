import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class tree1302 {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> temp =new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                temp.add(node.val);
            }
            list.add(temp);
        }

        ArrayList<Integer> arrayList = list.get(list.size() - 1);
        int sum = 0;
        for(int i = 0;i<arrayList.size();i++){
            sum+=arrayList.get(i);
        }
        return sum;
    }
}
