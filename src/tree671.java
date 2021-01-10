import java.util.*;

public class tree671 {

    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        preOrder(root);
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> store = new ArrayList<>();
        Collections.sort(arrayList);

        for(int i =0 ;i<arrayList.size();i++){
            if(!hashSet.contains(arrayList.get(i))) {
                store.add(arrayList.get(i));
            }
            hashSet.add(arrayList.get(i));
        }

        if(store.size() < 2 ) return  -1;

        return store.get(1);
    }

    ArrayList<Integer> arrayList = new ArrayList<>();
    public void preOrder(TreeNode root) {
        if(root != null){
            arrayList.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {

    }
}
