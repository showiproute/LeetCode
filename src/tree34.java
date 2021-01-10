import java.util.ArrayList;
import java.util.List;

public class tree34 {

    List<List<Integer>> rst = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return rst;
        dfs(root,sum,new ArrayList<>());
        return rst;
    }

    public void dfs(TreeNode root,int target,List<Integer> list) {
        if(root == null ) return;
        if(root.val == target && root.left ==null && root.right == null) {
            list.add(root.val);
            rst.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        dfs(root.left,target-root.val,list);
        dfs(root.right,target-root.val,list);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode p4 = new TreeNode(4);
        TreeNode p8 = new TreeNode(8);
        TreeNode p11 = new TreeNode(11);
        TreeNode p13 = new TreeNode(13);
        TreeNode p44=  new TreeNode(4);
        TreeNode p7 = new TreeNode(7);
        TreeNode p2  = new TreeNode(2);
        TreeNode p5 = new TreeNode(5);
        TreeNode p1 = new TreeNode(1);
        root.left = p4;
        root.right=p8;
        p4.left=p11;
        p11.left=p7;
        p11.right=p2;
        p8.left=p13;
        p8.right=p44;
        p44.left=p5;
        p4.right=p1;
        tree34 obj = new tree34();
        List<List<Integer>> lists = obj.pathSum(root, 22);
        System.out.println(lists.toString());
    }

}

