public class serializeTree {

    StringBuilder sb = new StringBuilder();
    public String serialize(TreeNode root){
        if(root != null) {
            preOrder(root);
        }

        return sb.toString();
    }

    public void preOrder(TreeNode root) {
        if(root!=null) {
            sb.append(root.val);
            if(root.left != null) {
                preOrder(root.left);
            }else{
                sb.append("#");
            }
            if(root.right != null) {
                preOrder(root.right);
            }else{
                sb.append("#");
            }
        }

    }

    public int index = 0;
    public TreeNode deserialize(String inputStr) {
        String s = inputStr.charAt(index) + "";
        if(s.equals("#")) {
            index++;
            return null;
        }else{
            TreeNode root = new TreeNode(Integer.parseInt(inputStr.charAt(index)+""));
            index++;
            root.left = deserialize(inputStr);
            root.right = deserialize(inputStr);
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        root.left =p2;
        root.right=p3;
        p3.left=p4;
        p3.right=p5;

        serializeTree obj = new serializeTree();
        String serialize = obj.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = obj.deserialize(serialize);
    }

}
