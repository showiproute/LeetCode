public class LinkedList0208 {

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        if(fast != slow) return null;
        fast = head;
        while(slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(0);
        ListNode p4 = new ListNode(-4);
        head.next = p2;
        p2.next=p3;
        p3.next=p4;
//        p4.next = p2;
        LinkedList0208 obj = new LinkedList0208();
        ListNode listNode = obj.detectCycle(head);
        System.out.println(listNode);
    }
}
