
public class LinkedListMs {

    public void sort(int[] nums,int left,int right,int[] temp) {
        if(left < right) {
            int mid = (left+right)/2;
            sort(nums,left,mid,new int[nums.length]);
            sort(nums,mid+1,right,temp);
            merge(nums,left,mid,right,temp);
        }
    }

    public void merge(int[] list,int left,int mid,int right,int[] temp) {
        int i = left;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=right) {
            if(list[i] == list[j]) {
                i++;
            }else if (list[i] < list[j]) {
                temp[k++] = list[i++];
            }else if (list[i] > list[j]) {
                temp[k++] = list[j++];
            }
        }

        while(i<=mid) {
            temp[k++] = list[i++];
        }
        while(j<=right) {
            temp[k++] = list[j++];
        }

        k = 0;
        while(left<=right) {
            list[left++] = temp[k++];
        }
    }

    public static void main(String[] args) {
        ListNode p = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        p.next = p2;
        p2.next=p3;
        int m = 3;

        ListNode q = new ListNode(4);
        ListNode q2 = new ListNode(3);
        ListNode q3 = new ListNode(2);
        q.next=q2;
        q2.next=q3;
        int n = 3;

        int[] nums = new int[n+m];
        int counts = 0;
        while(p!=null){
            nums[counts++] = p.val;
            p=p.next;
        }
        while(q!=null){
            nums[counts++] = q.val;
            q=q.next;
        }

        LinkedListMs obj = new LinkedListMs();
        obj.sort(nums,0,nums.length-1,new int[nums.length]);
        ListNode newHead = new ListNode(-1);
        ListNode rear =newHead;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != 0){
                ListNode newNode = new ListNode(nums[i]);
                rear.next = newNode;
                rear = newNode;
            }
        }
        newHead = newHead.next;
        while(newHead!=null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
