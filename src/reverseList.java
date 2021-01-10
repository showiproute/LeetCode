public class reverseList {

    public ListNode reverse(ListNode head) {
        if(head!=null && head.next!= null){
            ListNode ret = reverse(head.next);
            head.next.next = head;
            head.next = null;
            System.out.println("ret"+ret.val);
            return ret;
        }else{
            return head;
        }
    }

    //recursive
    // 4->3->2->1 == 4 <-3<-2<-1-newHead;
    public ListNode reverse_recursive(ListNode head) {
        if(head.next == null) return head;
        //递归 步骤1: 4->3->2->1 transfer to 4<-3<-2<-1  newHead 是1
        //先翻转node之后的链表
        ListNode newHead = reverse_recursive(head.next);
        //步骤2 改变指针指向 避免发生环路
        //把原node节点后继节点的后继节点指向node(4)，node的后继节点设置为空，防止环路
        head.next.next = head;
        head.next = null;

        //步骤3 返回翻转后的头节点
        return newHead;
    }

    //normal 迭代
    public ListNode reverse_normal(ListNode head) {
        ListNode prev = head.next;
        ListNode cur = prev.next;
        prev.next = null;

        while(cur!=null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        head.next = prev;
        return head;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        p1.next =p2;
        p2.next=p3;
        reverseList obj = new reverseList();
        ListNode reverse = obj.reverse(p1);
        while(reverse!=null){
            System.out.println(reverse.val);
            reverse = reverse.next;
        }

    }


}
