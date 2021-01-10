public class LinkedList0205 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 ==null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode newHead = new ListNode(-1);
        ListNode rear = newHead;
        int carry = 0;
        while(l1!=null && l2!=null){
            int sum = (l1.val+l2.val+carry);
            int rest = sum%10;
            carry = sum/10;
            ListNode newNode = new ListNode(rest);
            rear.next = newNode;
            rear = newNode;
            l1 =l1.next;
            l2 = l2.next;
        }

        if(l1 == null && l2 ==null){
            if(carry!=0){
                ListNode newNode = new ListNode(1);
                rear.next = newNode;
                rear = newNode;
                return newHead.next;
            }
        }


        if(l1 == null ){
            while(l2!=null) {
                int sum = (l2.val+carry);
                int rest = sum%10;
                carry = sum/10;
                ListNode newNode = new ListNode(rest);
                rear.next = newNode;
                rear = newNode;
                l2= l2.next;
            }
        }else {
            while(l1!=null){
                int sum = (l1.val+carry);
                int rest = sum%10;
                carry = sum/10;
                ListNode newNode = new ListNode(rest);
                rear.next =newNode;
                rear= newNode;
                l1 = l1.next;
            }
        }
        if(carry !=0){
            ListNode newNode = new ListNode(1);
            rear.next = newNode;
            rear = newNode;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(7);
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(9);
        a.next = p1;
        p1.next=p2;

        ListNode b= new ListNode(9);
        ListNode p3 = new ListNode(9);
        ListNode p4 = new ListNode(2);
        b.next=p3;
        p3.next=p4;
        LinkedList0205 obj = new LinkedList0205();
        ListNode listNode = obj.addTwoNumbers(a, b);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

}
