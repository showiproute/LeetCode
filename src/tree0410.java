public class tree0410 {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val == t2.val){
            return isSameTree(t1,t2);
        }else{
            boolean left = checkSubTree(t1.left, t2);
            boolean right = checkSubTree(t1.right, t2);
            return left || right;
        }
    }

    public boolean isSameTree(TreeNode t1,TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;
        boolean left = isSameTree(t1.left, t2.left);
        boolean right = isSameTree(t1.right, t2.right);
        return left&&right;
    }



}
