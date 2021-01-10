public class LinkedList876 {

    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = new ListNode(-1);
        ListNode slow = newHead;
        ListNode fast = newHead;
        newHead.next = head;
        while(fast!=null && fast.next !=null){

            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null && fast.next == null) return slow.next;
        return slow;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2=  new ListNode(2);
//        ListNode p3= new ListNode(3);
//        ListNode p4 = new ListNode(4);
//        ListNode p5 = new ListNode(5);
        p1.next= p2;
//        p2.next=p3;
//        p3.next=p4;
//        p4.next=p5;
        LinkedList876 obj = new LinkedList876();
        ListNode listNode = obj.middleNode(p1);
        System.out.println(listNode.val);
    }
}
