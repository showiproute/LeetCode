public class offer26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        if(A.val == B.val) {
            if(helper(A.left,B.left) && helper(A.right,B.right)){
                return true;
            }
        }

        return isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public boolean helper(TreeNode A,TreeNode B){
        if(B == null) return true;
        if(A == null) return false;
        if(A.val != B.val) return false;

        return helper(A.left,B.left) && helper(A.right,B.right);
    }

}
