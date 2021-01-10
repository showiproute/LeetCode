import java.util.HashSet;

public class LinkedList82 {

    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> removeSet = new HashSet<>();
        ListNode p = head;
        while(p!=null) {
            if(!hashSet.contains(p.val)) {
                hashSet.add(p.val);
            }else{
                removeSet.add(p.val);
            }
            p = p.next;
        }

        ListNode newHead = new ListNode(-1);
        ListNode rear = newHead;
        p = head;
        while(p!=null) {
            if(!removeSet.contains(p.val)) {
                ListNode newNode = new ListNode(p.val);
                rear.next = newNode;
                rear = newNode;
            }
            p = p.next;
        }

        return newHead.next;
    }

    /*
    输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:

输入: 1->1->1->2->3
输出: 2->3
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(2);
        ListNode p4 = new ListNode(3);
        ListNode p5 = new ListNode(4);
        ListNode p6 = new ListNode(4);
        ListNode p7 = new ListNode(5);
        head.next = p2;
        p2.next=p3;
        p3.next=p4;
        p4.next=p5;
        p5.next=p6;
        p6.next=p7;
        LinkedList82 obj = new LinkedList82();
        ListNode listNode = obj.deleteDuplicates(head);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
