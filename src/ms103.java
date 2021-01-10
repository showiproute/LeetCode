import java.util.*;

public class ms103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> store= new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
                store.add(node.val);
            }
            if(level%2 == 0) {
                Collections.reverse(store);
                result.add(store);
            }else{
                result.add(store);
            }
            level++;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p9 = new TreeNode(9);
        TreeNode p20 = new TreeNode(20);
        TreeNode p15 = new TreeNode(15);
        TreeNode p7 = new TreeNode(7);
        root.left = p9;
        root.right =p20;
        p20.left = p15;
        p20.right=p7;
        ms103 obj = new ms103();
        List<List<Integer>> lists = obj.zigzagLevelOrder(root);
        System.out.println(lists.toString());
    }



}
