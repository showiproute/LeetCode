public class LinkedList0202 {

    public int kthToLast(ListNode head, int k) {
        if(head == null || k <=0) return -1;
        ListNode newHead = new ListNode(-1);
        newHead.next=head;
        ListNode slow = newHead;
        ListNode fast = head;
        for(int i = 0;i<k-1;i++){
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        if(slow !=null ) return slow.val;
        return -1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        head.next =p2;
        p2.next=p3;
        LinkedList0202 obj = new LinkedList0202();
        int i = obj.kthToLast(head, 3);
        System.out.println(i);
    }
}
