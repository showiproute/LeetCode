public class LinkedList0206 {

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next ==null) return true;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode slow = newHead;
        ListNode fast = slow;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }

        ListNode rightHead = new ListNode(-1);
        rightHead.next = slow.next;

        ListNode prev = rightHead.next;
        ListNode cur = prev.next;
        prev.next = null;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        rightHead.next = prev;

        while(rightHead!=null && newHead!=null) {
            if(rightHead.val != newHead.val) {
                return false;
            }
            rightHead = rightHead.next;
            newHead = newHead.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(1);
        head.next= p2;
        p2.next = p3;

        LinkedList0206 obj = new LinkedList0206();
        boolean palindrome = obj.isPalindrome(head);
        System.out.println(palindrome);
    }
}
