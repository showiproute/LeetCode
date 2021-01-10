public class LinkedList141 {

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null) {
            if(slow == fast) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        p1.next=p2;
        p2.next=p1;
        LinkedList141 obj = new LinkedList141();
        boolean b = obj.hasCycle(p1);
        System.out.println(b);

    }

}
