public class LinkedList0207 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lengthA = 0;
        int lengthB = 0;
        ListNode p = headA;
        ListNode q = headB;
        while(p!=null){
            lengthA++;
            p = p.next;
        }
        while(q!=null){
            lengthB++;
            q=q.next;
        }
        p = headA;
        q = headB;
        if(lengthA < lengthB) {
            int dif = lengthB-lengthA;
            for(int i = 0;i<dif;i++){
                q = q.next;
            }
        }else if(lengthA > lengthB){
            int dir = lengthA - lengthB;
            for(int i  =0;i<dir;i++){
                p = p.next;
            }
        }

        while(p!=null && q!=null) {
            if(p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }

        return null;
    }


}
