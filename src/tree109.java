import java.util.ArrayList;

public class tree109 {

    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null ){
            list.add(head.val);
            head = head.next;
        }

        return buildTree(list,0,list.size()-1);
    }

    public TreeNode buildTree(ArrayList<Integer> list,int start,int end) {
        if(start>end) return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(list.get(mid));
        TreeNode left = buildTree(list, start, mid-1);
        TreeNode right = buildTree(list, mid+1, end);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        //-10, -3, 0, 5, 9
        ListNode head = new ListNode(-10);
        ListNode p1 = new ListNode(-3);
        ListNode p2 = new ListNode(0);
        ListNode p3 = new ListNode(5);
        ListNode p4 = new ListNode(9);
        head.next = p1;
        p1.next=p2;
        p2.next=p3;
        p3.next=p4;

        tree109 obj = new tree109();
        TreeNode treeNode = obj.sortedListToBST(head);
        System.out.println(treeNode.val);
        System.out.println(treeNode.left.right.val);
    }

}
