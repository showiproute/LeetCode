import java.util.ArrayList;

public class tree0406 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        dfs(root, p);
        if (index+1 >= list.size()) {
            return null;
        } else {
            return list.get(index+1);
        }
    }

    ArrayList<TreeNode> list = new ArrayList<>();
    int index = 0;
    public void dfs(TreeNode root,TreeNode p) {
        if(root!=null){
            dfs(root.left,p);
            list.add(root);
            if(root.val == p.val) {
                index = list.size()-1;
            }
            dfs(root.right,p);
        }
    }


}
