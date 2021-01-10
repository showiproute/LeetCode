import java.util.ArrayList;

public class tree437 {

    public int counts = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return counts;
        dfs(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return counts;
    }

    public void dfs(TreeNode root,int sum) {
        if(root == null) return;
        if(root.val == sum) {
            counts++;
        }
        dfs(root.left,sum-root.val);
        dfs(root.right,sum-root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p2 =new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        root.right = p2;
        p2.right=p3;
        p3.right=p4;
        p4.right=p5;
        tree437 obj = new tree437();
        int sum = obj.pathSum(root, 3);
        System.out.println(sum);
    }

}
