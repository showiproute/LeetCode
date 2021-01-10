public class LinkedList25 {

    public ListNode prev = null;
    public ListNode from = null;
    public ListNode to = null;
    public ListNode next = null;

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <=1) return head;
        int length = length(head);
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        prev = newHead;

        for(int i = 0 ;i<length/k;i++){
            helper(prev,k);
            if(prev!=null) {
                prev.next = to;
            }
            if(from!=null){
                from.next = next;
            }
            prev = from;
        }

        return newHead.next;
    }

    public void helper(ListNode head,int end) {
        int counts = 0;
        while(counts<=end+1 && head!=null) {
            if(counts == 0) {
                prev = head;
            }else if(counts ==1) {
                from = head;
            }else if(counts == end) {
                to = head;
            }else if(counts == end+1){
                next = head;
            }
            head = head.next;
            counts++;
        }
//        System.out.println("prev"+prev.val);
//        System.out.println("from"+from.val);
//        System.out.println("to"+to.val);
        if(to.next ==null) {
            next = null;
        }
//        if(next!=null){
//            System.out.println("next"+next.val);
//        }
//        System.out.println("=============");
        //翻转
        ListNode p = from;
        ListNode cur = p.next;
        p.next = null;
        while(cur!=null && cur!=next){
            ListNode temp = cur.next;
            cur.next = p;
            p = cur;
            cur = temp;
        }
    }

    public int length(ListNode head) {
        ListNode p = head;
        int length =0;
        while(p!=null) {
            length++;
            p=p.next;
        }
        return length;
    }


    public static void main(String[] args) {
        ListNode newHead = new ListNode(-1);
        ListNode head = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
//        ListNode p5 = new ListNode(5);
        newHead.next = head;
        head.next =p2;
        p2.next=p3;
        p3.next=p4;
//        p4.next=p5;
        LinkedList25 obj = new LinkedList25();
//        obj.helper(newHead,2);

        ListNode listNode = obj.reverseKGroup(head, 2);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
