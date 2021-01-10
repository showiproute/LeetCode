import java.util.HashMap;

public class tree1325 {

//    public TreeNode removeLeafNodes(TreeNode root, int target) {
//        if(root == null) return root;
//        //parent
//        buildPar(root,null);
//        postOrder(root,target);
//        if(root.val == target && root.left ==null && root.right == null) return null;
//        return root;
//    }
//
//    HashMap<TreeNode,TreeNode> parMap = new HashMap<>();
//    public void buildPar(TreeNode root,TreeNode par) {
//        if(root!=null){
//            parMap.put(root,par);
//            buildPar(root.left,root);
//            buildPar(root.right,root);
//        }
//    }
//
//    public void postOrder(TreeNode root,int target) {
//        if(root!=null){
//            postOrder(root.left,target);
//            postOrder(root.right,target);
//            if(root.val == target) {
//                if(root.left == null && root.right == null){
//                    TreeNode par = parMap.getOrDefault(root,null);
//                    if(par != null){
//                        if(par.left == root) {
//                            par.left = null;
//                        }else if(par.right == root){
//                            par.right = null;
//                        }
//                    }
//                }
//            }
//        }
//    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return null;
        root.left = removeLeafNodes(root.left,target);
        root.right = removeLeafNodes(root.right,target);

        if(root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }

    public static void main(String[] args) {
        tree1325 obj = new tree1325();
        TreeNode root = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        TreeNode p3 = new TreeNode(2);
        TreeNode p4 = new TreeNode(2);
        TreeNode p5 = new TreeNode(4);
        root.left = p1;
        root.right=p2;
        p1.left = p3;
        p2.left = p4;
        p2.right = p5;
        TreeNode treeNode = obj.removeLeafNodes(root, 2);
        System.out.println(treeNode.left);
    }

}
