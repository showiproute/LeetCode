import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LinkedList147 {

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = new ListNode(-1);
        ListNode rear = newHead;

        ArrayList<ListNode> arrayList = new ArrayList<>();
        while(head!=null){
            arrayList.add(head);
            head = head.next;
        }
        Collections.sort(arrayList, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode item : arrayList) {
            rear.next = item;
            rear = item;
            rear.next = null;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(4);
        ListNode p2= new ListNode(2);
        ListNode p3 = new ListNode(1);
        ListNode p4 = new ListNode(3);
        p1.next=p2;
        p2.next=p3;
        p3.next=p4;
        LinkedList147 obj = new LinkedList147();
        ListNode listNode = obj.insertionSortList(p1);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
