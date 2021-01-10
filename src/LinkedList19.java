import java.util.LinkedHashMap;

public class LinkedList19 {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if(head == null || n <=0) return head;
//        if(head.next == null && n ==1) return null;
//        int length = 0;
//        ListNode p = head;
//        while(p!=null) {
//            length++;
//            p=p.next;
//        }
//        if(length == n) {
//            return head.next;
//        }
//
//        p = head;
//        ListNode prev = p;
//
//        for(int i = 0;i<length-n;i++) {
//            prev = p;
//            p=p.next;
//        }
//        prev.next = p.next;
//
//        return head;
//    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <=0 ) return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode slow = newHead;
        ListNode fast = newHead.next;
        for(int i = 0 ;i<n;i++){
            fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return newHead.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        ListNode p1=  new ListNode(2);
//        ListNode p2= new ListNode(3);
//        ListNode p3 = new ListNode(4);
//        ListNode p4 = new ListNode(5);
//        head.next =p1;
//        p1.next=p2;
//        p2.next=p3;
//        p3.next=p4;
        LinkedList19 obj = new LinkedList19() ;
        ListNode listNode = obj.removeNthFromEnd(head, 1);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

}
