import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LinkedList23 {


    //normal
//    public ListNode mergeKLists(ListNode[] lists) {
//        if(lists == null || lists.length ==0) return null;
//
//        ArrayList<ListNode> arrayList = new ArrayList<>();
//        for(int i = 0;i<lists.length;i++){
//            ListNode head = lists[i];
//            while(head!=null){
//                arrayList.add(head);
//                head = head.next;
//            }
//        }
//        Collections.sort(arrayList, new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        });
//
//        ListNode newHead = new ListNode(-1);
//        ListNode p =newHead;
//        for(ListNode node : arrayList) {
//            p.next = node;
//            p = node;
//        }
//
//        return newHead.next;
//    }


    public ListNode mergeKLists(ListNode[] lists) {
        return helper(lists,0,lists.length-1);
    }

    public ListNode helper(ListNode[] lists,int left,int right) {
        if(left > right)  return null;
        if(left == right) return lists[left];

        int mid = left+(right-left)/2;
        return merge(helper(lists,left,mid),helper(lists,mid+1,right));
    }


    public ListNode merge(ListNode first,ListNode second) {
        ListNode newHead = new ListNode(-1);
        ListNode rear = newHead;
        ListNode p = first;
        ListNode q= second;
        while(p!=null && q!=null){
            if(p.val <= q.val) {
                ListNode next = p.next;
                rear.next = p;
                rear = p;
                p.next=null;
                p =next;
            }else {
                ListNode next = q.next;
                rear.next = q;
                rear = q;
                q.next = null;
                q=next;
            }
        }

        if(p == null){
            rear.next = q;
        }else {
            rear.next = p;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode p1 = new ListNode(4);
        ListNode p2 = new ListNode(5);
        a.next =p1;
        p1.next=p2;

        ListNode b= new ListNode(1);
        ListNode p3=new ListNode(3);
        ListNode p4 = new ListNode(4);
        b.next=p3;
        p3.next=p4;

        LinkedList23 obj = new LinkedList23();
        ListNode merge = obj.merge(a, b);
        while(merge!=null){
            System.out.println(merge.val);
            merge = merge.next;
        }

    }
}
