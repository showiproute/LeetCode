public class LinkedList234 {

    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2= secondHalfStart;
        boolean result = true;
        while(result && p2!=null) {
            if(p1.val != p2.val){
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode endOfFirstHalf(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast =fast.next.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(0);
        ListNode p3 = new ListNode(1);
//        ListNode p4 = new ListNode(1);
        p1.next =p2;
        p2.next=p3;
//        p3.next=p4;
        LinkedList234 obj = new LinkedList234();
        boolean palindrome = obj.isPalindrome(p1);
        System.out.println(palindrome);
//        ListNode listNode = obj.reverseList(p3);
//        while(listNode!=null){
//            System.out.println(listNode.val);
//            listNode= listNode.next;
//        }
    }
}

