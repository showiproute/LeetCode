import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkedList86 {

    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode newHead = new ListNode(-1);
        ListNode p = newHead;
        LinkedHashMap<Integer,ListNode> linkedHashMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int cnts = 0;
        while(head!=null){
            if(head.val < x) {
                list.add(cnts);
            }else{
                list2.add(cnts);
            }
            linkedHashMap.put(cnts,head);
            head= head.next;
            cnts++;
        }
        for(int i = 0;i<list.size();i++){
            ListNode node = linkedHashMap.get(list.get(i));
            p.next = node;
            p = node;
        }
        for(int i =0 ;i<list2.size();i++){
            ListNode node = linkedHashMap.get(list2.get(i));
            p.next = node;
            p = node;
        }
        p.next = null;

        return newHead.next;
    }

    /*
输入：head = 1->4->3->2->5->2, x = 3
输出：1->2->2->4->3->5
 */
    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2= new ListNode(4);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(2);
        ListNode p5 = new ListNode(5);
        ListNode p6 = new ListNode(2);
        p1.next = p2;
        p2.next=p3;
        p3.next=p4;
        p4.next=p5;
        p5.next=p6;
        LinkedList86 obj = new LinkedList86();
        ListNode partition = obj.partition(p1, 3);
        while(partition!=null){
            System.out.println(partition.val);
            partition = partition.next;
        }
    }


}
