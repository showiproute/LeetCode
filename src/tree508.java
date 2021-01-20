import java.util.*;

public class tree508 {

    ArrayList<Integer> arrayList = new ArrayList<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null ) return new int[]{};
        helper(root);
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int maxSize = 0;
        for(Integer item : arrayList){
            hashMap.put(item,hashMap.getOrDefault(item,0)+1);
            maxSize = Math.max(maxSize,hashMap.get(item));
        }
        ArrayList<Integer> rst = new ArrayList<>();
        for(Map.Entry<Integer,Integer> keyValue : hashMap.entrySet()) {
            if(keyValue.getValue() == maxSize) {
                rst.add(keyValue.getKey());
            }
        }
        int[] result = new int[rst.size()];
        for(int i =0 ;i<rst.size();i++){
            result[i] = rst.get(i);
        }

        return result;
    }

    public void helper(TreeNode root) {
        if(root!=null) {
            int val = sumTree(root);
            arrayList.add(val);
            helper(root.left);
            helper(root.right);
        }
    }

    public int sumTree(TreeNode root) {
        if(root == null) return 0;
        int left = sumTree(root.left);
        int right = sumTree(root.right);
        return root.val+left+right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(-3);
        root.left = p1;
        root.right=p2;
        tree508 obj = new tree508();
        int[] frequentTreeSum = obj.findFrequentTreeSum(root);
        System.out.println(Arrays.toString(frequentTreeSum));
    }


}
