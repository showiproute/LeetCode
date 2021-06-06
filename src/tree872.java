import com.sun.source.tree.Tree;

import java.util.ArrayList;

public class tree872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        helper(root1,list1);
        helper(root2,list2);
        if(list1.size() != list2.size()) return false;
        for(int i = 0;i<list1.size();i++){
            if(!list1.get(i).equals(list2.get(i))) return false;
        }

        return true;
    }

    public void helper(TreeNode root,ArrayList<Integer> list) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        helper(root.left,list);
        helper(root.right,list);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(3);
        root1.left = r1;
        root1.right = r2;

        TreeNode root2 = new TreeNode(1);

    }
}
