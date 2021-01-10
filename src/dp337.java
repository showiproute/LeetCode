import java.util.HashMap;
import java.util.Map;

public class dp337 {

    HashMap<TreeNode,Integer> hashMap = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null) return 0;

        if(hashMap.containsKey(root)) return hashMap.get(root);

        //do it
        int do_it = root.val;
        if(root.left != null) {
            do_it = rob(root.left.left);
            do_it = rob(root.left.right);
        }
        if(root.right != null) {
            do_it = rob(root.right.left);
            do_it = rob(root.right.right);
        }

        //not do
        int not_do = rob(root.left)+rob(root.right);
        int res = Math.max(do_it,not_do);
        hashMap.put(root,res);

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p2 = new TreeNode(4);
        TreeNode p3 = new TreeNode(5);
        TreeNode p33 = new TreeNode(1);
        TreeNode p1 = new TreeNode(3);
        TreeNode p11 = new TreeNode(1);
        TreeNode p233 = new TreeNode(3333);
        root.left = p2;
        root.right = p3;
        p2.left = p33;
        p2.right = p1;
        p3.right = p11;
        p3.left = p233;
        dp337 obj = new dp337();
        int rob = obj.rob(root);
        for(Map.Entry<TreeNode,Integer> keyValue : obj.hashMap.entrySet()) {
            System.out.println(keyValue.getKey().val);
            System.out.println(keyValue.getValue());
            System.out.println("======");
        }
        System.out.println(rob);
     }


}
