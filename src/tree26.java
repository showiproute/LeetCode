public class tree26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        if(A.val == B.val) {
            if(isSubTree(A.left,B.left) && isSubTree(A.right,B.right)){
                return true;
            }
        }

        return isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }


    public boolean isSubTree(TreeNode A,TreeNode B) {
        if(B == null) return true;
        if(A == null) return false;
        if(A.val != B.val) return false;
        boolean left = isSubTree(A.left,B.left);
        boolean right = isSubTree(A.right,B.right);
        return left&&right;
    }
}