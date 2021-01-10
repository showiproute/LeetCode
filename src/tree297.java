import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class tree297 {


    StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        preOrder(root);
        return sb.toString();
    }

    public void preOrder(TreeNode root) {
        if(root!=null) {
            sb.append(root.val).append(",");
            preOrder(root.left);
            preOrder(root.right);
        }else{
            sb.append("#,");
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        TreeNode root = build(split);
        return root;
    }

    int index = 0;

    public TreeNode build(String[] nodes) {
        if(nodes[index].equals("#")) {
            index++;
            return null;
        }
        int value = Integer.parseInt(nodes[index]);
        TreeNode root = new TreeNode(value);
        index++;
        root.left = build(nodes);
        root.right = build(nodes);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        TreeNode p2 = new TreeNode(-2);
        TreeNode p3 = new TreeNode(-3);
        TreeNode p4 = new TreeNode(-4);
        TreeNode p5 = new TreeNode(-5);
        root.left = p2;
        root.right=p3;
        p3.left=p4;
        p3.right=p5;
        tree297 obj = new tree297();
        String serialize = obj.serialize(root);
        TreeNode build = obj.deserialize(serialize);
        System.out.println(build.val);
    }

}
