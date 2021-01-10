import java.util.*;

public class ms450 {

    public TreeNode deleteNode(TreeNode root,int key) {
        if(root == null) return root;
        if(root.val < key) root.right = deleteNode(root.right,key);
        else if(root.val > key) root.left = deleteNode(root.left,key);
        else{
            if(root.left == null && root.right == null) {
                root = null;
            }else if(root.right != null) {
                TreeNode successor = successor(root);
                root.val = successor.val;
                root.right = deleteNode(root.right,successor.val);
            }else{
                TreeNode decessor = decessor(root);
                root.val = decessor.val;
                root.left = deleteNode(root.left,decessor.val);
            }
        }

        return root;
    }

    public TreeNode successor(TreeNode root) {
        root = root.right;
        while(root.left !=null) {
            root = root.left;
        }
        return root;
    }

    public TreeNode decessor(TreeNode root) {
        root = root.left;
        while(root.right != null) {
            root = root.right;
        }

        return root;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
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
            result.add(store);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode p3 = new TreeNode(3);
        TreeNode p6 = new TreeNode(6);
        TreeNode p2 = new TreeNode(2);
        TreeNode p4 = new TreeNode(4);
        TreeNode p7 = new TreeNode(7);
        root.left = p3;
        root.right=p6;
        p3.left=p2;
        p3.right=p4;
        p6.right=p7;

        ms450 obj = new ms450();
        TreeNode treeNode = obj.deleteNode(root, 7);
        List<List<Integer>> lists = obj.zigzagLevelOrder(root);
        System.out.println(lists.toString());

    }
}

