public class LinkedList143 {

    /*
    示例 1:
给定链表 1->2->3->4, 重新排列为 1->4->2->3.
示例 2:
给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode p = head;
        while(p!=null && p.next!=null){
            ListNode last = findLastNode(p);
            last.next = p.next;
            p.next = last;
            p = p.next.next;
        }
    }

    public ListNode findLastNode(ListNode head) {
        ListNode prev = head;
        ListNode p = prev.next;
        while(p.next!=null){
            p=p.next;
            prev=prev.next;
        }
        prev.next = p.next;
        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        head.next=p2;
        p2.next=p3;
        p3.next=p4;
        p4.next =p5;
        LinkedList143 obj = new LinkedList143();
        obj.reorderList(head);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }


}
