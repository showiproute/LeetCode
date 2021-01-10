import java.util.*;

public class tree501 {

    TreeMap<Integer,Integer> map = new TreeMap<>();

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};
        inOrder(root);

        int maxSize = 0;
        for(Map.Entry<Integer,Integer> keyValue : map.entrySet()) {
            if(keyValue.getValue() > maxSize ) {
                maxSize = keyValue.getValue();
            }
        }
        ArrayList<Integer> list=  new ArrayList<>();
        for(Map.Entry<Integer,Integer> keyValue:map.entrySet()) {
            if(keyValue.getValue() == maxSize) {
                list.add(keyValue.getKey());
            }
        }
        int[] rst=  new int[list.size()];
        for(int i = 0;i<list.size();i++){
            rst[i] = list.get(i);
        }

        return rst;
    }

    public void inOrder(TreeNode root) {
        if(root!=null){
            inOrder(root.left);
            map.put(root.val,map.getOrDefault(root.val,0)+1);
            inOrder(root.right);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p2=  new TreeNode(2);
        TreeNode p22 =new TreeNode(2);
        TreeNode p33 = new TreeNode(33);
        TreeNode p333 = new TreeNode(33);
        TreeNode p3333 = new TreeNode(33);
        root.right=p2;
        p2.left=p22;
        p22.right=p33;
        p33.right=p333;
        p333.right=p3333;
        tree501 obj = new tree501();
        int[] mode = obj.findMode(root);
        System.out.println(obj.map.toString());

    }
}
