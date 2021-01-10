public class ms206 {

    public ListNode reverseList(ListNode head) {
        if(head ==null ) return head;
        ListNode newHead = null;
        ListNode p = head;
        while(p!=null) {
            ListNode temp = p.next;
            p.next = newHead;
            newHead = p;
            p =temp;
        }

        return newHead;
    }

    //递归
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode cur = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return cur;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        p1.next =p2;
        p2.next=p3;
        ms206 obj = new ms206();
        ListNode listNode = obj.reverseList(p1);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

}
