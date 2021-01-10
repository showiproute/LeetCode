public class LinkedList0204 {

    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;

        ListNode one = new ListNode(-1);
        ListNode a= one;

        ListNode two = new ListNode(-1);
        ListNode b = two;

        while(head!=null){
            ListNode newNode = new ListNode(head.val);
            if(head.val < x) {
                a.next = newNode;
                a=newNode;
            }else {
                b.next = newNode;
                b = newNode;
            }
            head = head.next;
        }

        a.next = two.next;
        return one.next;
    }

}
