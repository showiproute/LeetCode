public class offer33 {

    //1,3,2,6,5
    /*
    5
  2   7
1  3  6  8

1 3 2 6 8 7 5

     */
    public boolean verifyPostorder(int[] postorder) {
        return isPost(postorder,0,postorder.length-1);
    }

    public boolean isPost(int[] postorder,int left,int right) {
        if(left>=right) return true;
        int p = left;
        while(postorder[p]<postorder[right]) p++;
        int mid = p;
        while(postorder[p]>postorder[right]) p++;
        return p == right && isPost(postorder,left,mid-1) && isPost(postorder,mid,right-1);
    }

    public static void main(String[] args) {
        int[] post = {1,6,3,2,5};
        offer33 obj = new offer33();
        boolean b = obj.verifyPostorder(post);
        System.out.println(b);
    }
}
