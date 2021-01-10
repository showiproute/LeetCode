import java.util.ArrayList;

public class tree0405 {

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        inOrder(root);
        for(int i = 0;i<rst.size()-1;i++){
            if (rst.get(i) >= rst.get(i+1)){
                return false;
            }
        }

        return true;
    }

    ArrayList<Integer> rst = new ArrayList<>();

    public void inOrder(TreeNode root) {
        if(root!=null){
            inOrder(root.left);
            rst.add(root.val);
            inOrder(root.right);
        }
    }
}
