import java.util.ArrayList;
import java.util.Scanner;



public class netEase01 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x ){
            val = x;
        }
    }

    public static  ListNode mergeKList(ListNode[] list) {
        ListNode rest = new ListNode(0);
        if(list == null || list.length == 0){
            return null;
        }else if(list.length ==1){
            return list[0];
        }else if (list.length == 2){
            mergeTwoLists(list[0],list[1]);
        }else{
            rest = mergeTwoLists(list[0],list[1]);
            for(int i =2;i<list.length;i++){
                mergeTwoLists(rest,list[i]);
            }
        }

        return rest;
    }

    public static  ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        ListNode rest = new ListNode(-1);
        ListNode temp = rest;

        while(l1 != null && l2 !=null ) {
            if(l1.val < l2.val ) {
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if(l1 != null) {
            temp.next = l1;
        }else{
            temp.next = l2;
        }

        return rest.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i =0;i<n;i++){
                String[] s = sc.nextLine().split(" ");
                arrayList.add(Integer.parseInt(s[i]));
            }
            ListNode[] nodeList = new ListNode[arrayList.size()];
            for(int i =0;i<arrayList.size();i++){
                ListNode listNode = new ListNode(arrayList.get(i));
                nodeList[i] = listNode;
            }
            ListNode listNode = mergeKList(nodeList);
            while(listNode!=null){
                System.out.println(listNode.val);
                listNode = listNode.next;
            }
        }


    }
}
