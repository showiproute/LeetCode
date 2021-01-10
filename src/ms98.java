import java.util.ArrayList;

public class ms98 {

    public boolean isValid = true;

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
//        inOrder(root);
//        for(int i = 0;i<rst.size()-1;i++){
//            int j = i+1;
//            if(rst.get(i) >= rst.get(j)) return false;
//        }

        dfs(root,null,null);
        return isValid;
    }

    ArrayList<Integer> rst = new ArrayList<>();
    //method inOrder
    public void inOrder(TreeNode root) {
        if(root!=null){
            inOrder(root.left);
            rst.add(root.val);
            inOrder(root.right);
        }
    }

    //method dfs
    public void dfs(TreeNode root,Integer low,Integer high) {
        if(root == null) return;
        if(low != null && root.val <= low) isValid = false;
        if(high != null && root.val >= high) isValid = false;

        dfs(root.left,low,root.val);
        dfs(root.right,root.val,high);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode p1 = new TreeNode(1);
        TreeNode p4 = new TreeNode(4);
        TreeNode p3=  new TreeNode(3);
        TreeNode p6 = new TreeNode(6);
        root.left = p1;
        root.right=p4;
        p4.left=p3;
        p4.right=p6;
        ms98 obj = new ms98();
        boolean validBST = obj.isValidBST(root);
        System.out.println(validBST);
    }
}
