
import java.util.*;

public class tree652 {
    HashMap<String,Integer> hashMap = new HashMap<>();
    List<TreeNode> rst = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return new ArrayList<>();
        serial(root);
        return rst;
    }

    public String serial(TreeNode root) {
        if(root == null) return "#";
        String s = root.val + "," + serial(root.left) + "," + serial(root.right);
        hashMap.put(s,hashMap.getOrDefault(s,0)+1);
        if(hashMap.get(s) == 2) {
            rst.add(root);
        }
        return s;
    }

    public static void main(String[] args) {
        tree652 obj = new tree652();
        TreeNode root = new TreeNode(0);
        TreeNode p1 = new TreeNode(0);
        TreeNode p2 = new TreeNode(0);
        TreeNode p3 = new TreeNode(0);
        TreeNode p4 = new TreeNode(0);
        TreeNode p5 = new TreeNode(0);
        TreeNode p6 = new TreeNode(0);
        root.right = p1;
        p1.left = p2;
        p2.left =p3;
        p2.right=p4;
        p3.right=p5;
        p4.left = p6;
        List<TreeNode> duplicateSubtrees = obj.findDuplicateSubtrees(root);
        for(TreeNode node : duplicateSubtrees) {
            System.out.println(node.val);
        }

    }


}
