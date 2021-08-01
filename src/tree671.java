import java.util.*;

public class tree671 {

    public int findSecondMinimumValue(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        preOrder(root,arrayList);
        Collections.sort(arrayList);
        int pre = arrayList.get(0);
        for(int i = 1;i<arrayList.size();i++){
            if(arrayList.get(i) != pre) {
                return arrayList.get(i);
            }
        }

        return -1;
    }

    public void preOrder(TreeNode root,ArrayList<Integer> arrayList) {
        if(root != null) {
            arrayList.add(root.val);
            preOrder(root.left,arrayList);
            preOrder(root.right,arrayList);
        }
    }


    public static void main(String[] args) {

    }
}
