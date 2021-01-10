public class LinkedList92 {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m > n) return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = null;
        ListNode from = null;
        ListNode to = null;
        ListNode cur = null;

        ListNode temp = newHead;
        int counts = 0;
        while(temp!=null){
            if(counts == m-1) {
                pre = temp;
            }else if(counts == m) {
                from = temp;
            }else if(counts == n){
                to = temp;
            }else if(counts == n+1) {
                cur = temp;
            }
            temp = temp.next;
            counts++;
        }
        if(to == null || from == null) return head;

        ListNode p = from;
        ListNode q = from.next;
        while(q != cur) {
            ListNode next = q.next;
            q.next = p;
            p = q;
            q = next;
        }


        pre.next = to;
        from.next = cur;

        return newHead.next;
    }
    /*  pre from   to cur
    输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
     */
    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2= new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next=p3;
        p3.next=p4;
        p4.next=p5;
        LinkedList92 obj = new LinkedList92();
        ListNode listNode = obj.reverseBetween(p1, 1, 5);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
