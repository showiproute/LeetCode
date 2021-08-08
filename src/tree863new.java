import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class tree863new {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parMap = new HashMap<>();
        buildTree(root,parMap);
        List<Integer> rst = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        dfs(target,k,parMap,rst,visited);

        return rst;
    }

    public void dfs(TreeNode target, int distance,HashMap<TreeNode,TreeNode> parMap,
                    List<Integer> rst, HashSet<TreeNode> visited) {
        if(visited.contains(target)) return;
        if(distance == 0) {
            rst.add(target.val);
            return;
        }
        visited.add(target);
        //left
        if(target.left != null) {
            dfs(target.left,distance-1,parMap,rst,visited);
        }
        //right
        if(target.right != null) {
            dfs(target.right,distance-1,parMap,rst,visited);
        }
        if(parMap.containsKey(target)) {
            TreeNode par = parMap.get(target);
            dfs(par,distance-1,parMap,rst,visited);
        }
    }

    public void buildTree(TreeNode root, HashMap<TreeNode,TreeNode> parMap) {
        if(root!=null) {
            if(root.left != null) {
                parMap.put(root.left,root);
            }
            if(root.right != null){
                parMap.put(root.right,root);
            }
            buildTree(root.left,parMap);
            buildTree(root.right,parMap);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p5 = new TreeNode(5);
        TreeNode p1=  new TreeNode(1);
        TreeNode p6 = new TreeNode(6);
        TreeNode p2 = new TreeNode(2);
        TreeNode p0 = new TreeNode(0);
        TreeNode p8 = new TreeNode(8);
        TreeNode p7 = new TreeNode(7);
        TreeNode p4 = new TreeNode(4);
        tree863 obj = new tree863();
        root.left = p5;
        root.right =p1;
        p5.left =p6;
        p5.right=p2;
        p1.left=p0;
        p1.right=p8;
        p2.left=p7;
        p2.right=p4;
        List<Integer> integers = obj.distanceK(root, p5, 2);
        System.out.println(integers.toString());
    }
}
