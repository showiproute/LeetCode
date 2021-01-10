import java.util.HashSet;

public class LinkedList0201 {

    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null || head.next == null ) return head;
        HashSet<Integer> hashSet = new HashSet<>();
        ListNode cur = head;

        while(cur!=null && cur.next!=null) {
            hashSet.add(cur.val);
            if(hashSet.contains(cur.next.val)){
                ListNode p = cur;
                while(p!=null && hashSet.contains(p.val)) {
                     p = p.next;
                }
                cur.next =p;
            }
            cur = cur.next;
        }

        //1 2 2 2 2 3 3 3
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(2);
        ListNode p4 = new ListNode(2);
        ListNode p5 = new ListNode(3);
        ListNode p6 = new ListNode(3);
        ListNode p7= new ListNode(3);
        head.next = p2;
        p2.next=p3;
        p3.next=p4;
        p4.next=p5;
        p5.next=p6;
        p6.next=p7;
        LinkedList0201 obj = new LinkedList0201();
        ListNode listNode = obj.removeDuplicateNodes(head);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode =listNode.next;
        }

    }
}
