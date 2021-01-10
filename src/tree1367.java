
public class tree1367 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null || root == null) return false;
        boolean helper = helper(head, root);
        boolean left = isSubPath(head, root.left);
        boolean right = isSubPath(head, root.right);
        return left || right || helper;
    }

    public boolean helper(ListNode head,TreeNode root) {
        if(head!=null && root!=null){
            if(head.val == root.val) {
                if(head.next == null) {
                    return true;
                }else{
                    boolean left = helper(head.next, root.left);
                    boolean right = helper(head.next, root.right);
                    return left || right;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p1 = new TreeNode(4);
        TreeNode p2 = new TreeNode(4);
        TreeNode p3= new TreeNode(2);
        TreeNode p4 = new TreeNode(2);
        TreeNode p5 = new TreeNode(1);
        TreeNode p6 = new TreeNode(6);
        TreeNode p7 = new TreeNode(8);
        TreeNode p8 = new TreeNode(1);
        TreeNode p9 = new TreeNode(3);
        root.left =p1;
        root.right=p2;
        p1.left=p3;
        p2.left=p4;
        p3.left=p5;
        p4.left= p6;
        p4.right=p7;
        p7.left=p8;
        p7.right=p9;

        ListNode head = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n8 = new ListNode(8);
        head.next = n2;
        n2.next=n8;

        tree1367 obj = new tree1367();
        boolean subPath = obj.isSubPath(head, root);
        System.out.println(subPath);
//        boolean helper = obj.helper(head, p2);
//        System.out.println(helper);
    }



}
