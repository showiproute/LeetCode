import java.util.ArrayList;
import java.util.List;

public class tree95 {


    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> rst = new ArrayList<>();
        if(n==0) return rst;

        rst = build(1, n);
        return rst;
    }

    public List<TreeNode> build(int left,int right) {
        List<TreeNode> rst = new ArrayList<>();
        if(left > right){
            rst.add(null);
            return rst;
        }
        if(left == right) {
            TreeNode root = new TreeNode(left);
            rst.add(root);
            return rst;
        }
        for(int i = left;i<=right;i++){
            List<TreeNode> leftNodes = build(left, i - 1);
            List<TreeNode> rightNodes = build(i + 1, right);
            for(TreeNode lNode : leftNodes) {
                for(TreeNode rNode : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = lNode;
                    root.right = rNode;
                    rst.add(root);
                }
            }
        }
        return rst;
    }



}
