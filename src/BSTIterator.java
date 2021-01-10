import java.util.ArrayList;

public class BSTIterator {

    public BSTIterator(TreeNode root) {
        inOrder(root);
    }

    ArrayList<Integer> arrayList = new ArrayList<>();
    int index =0 ;
    public void inOrder(TreeNode root) {
        if(root!=null){
            inOrder(root.left);
            arrayList.add(root.val);
            inOrder(root.right);
        }
    }

    /** @return the next smallest number */
    public int next() {
        return arrayList.get(index++);
    }


    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index<arrayList.size();
    }



}
