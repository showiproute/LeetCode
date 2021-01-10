import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class nextGreaterNumber1019 {

    public int[] nextLargerNodes(ListNode head) {
        if(head == null ) return  new int[]{};
        if(head.next == null) return new int[]{0};

        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }

        int[] rst = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for(int i = rst.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() < list.get(i)){
                stack.pop();
            }
            if(stack.isEmpty()) {
                rst[i] = 0;
            }else{
                rst[i] = stack.peek();
            }

            stack.push(list.get(i));
        }

        return rst;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode p2= new ListNode(1);
        ListNode p3=  new ListNode(5);
        head.next=p2;
        p2.next=p3;
        nextGreaterNumber1019 obj = new nextGreaterNumber1019();
        int[] ints = obj.nextLargerNodes(head);
        System.out.println(Arrays.toString(ints));
    }
}
