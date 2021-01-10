
import java.util.*;

public class tree863 {

    /*
    public HashMap<TreeNode,TreeNode> parMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> rst = new ArrayList<>();
        if(root == null || target == null) return rst;
        helper(root,null);
        Queue<TreeNode> queue = new LinkedList<>();
        //哨兵node
        TreeNode temp = new TreeNode(-233);
        queue.offer(temp);
        queue.offer(target);
        HashSet<TreeNode> hasMet = new HashSet<>();
        hasMet.add(target);
        hasMet.add(null);

        int length = 0;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == temp) {
                if(length == K) {
                    int size = queue.size();
                    for(int i = 0;i<size;i++){
                        TreeNode poll = queue.poll();
                        rst.add(poll.val);
                    }
                    return rst;
                }else{
                    length++;
                    queue.offer(temp);
                }
            }else{
                if(!hasMet.contains(node.left)) {
                    hasMet.add(node.left);
                    queue.offer(node.left);
                }
                if(!hasMet.contains(node.right)){
                    hasMet.add(node.right);
                    queue.offer(node.right);
                }
                if(!hasMet.contains(parMap.get(node))){
                    hasMet.add(parMap.get(node));
                    queue.offer(parMap.get(node));
                }
            }
        }

        return rst;
    }

    public void helper(TreeNode root,TreeNode par) {
        if(root!=null){
            parMap.put(root,par);
            helper(root.left,root);
            helper(root.right,root);
        }
    }
     */
    List<Integer> rst = new ArrayList<>();
    HashMap<TreeNode,TreeNode> hashMap = new HashMap<>();
    HashSet<TreeNode> visited = new HashSet<>();

    int distance ;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if(root == null || target == null || K < 0) return rst;
        buildParMap(root,null);
        this.distance = K;
        dfs(target,0);
        return rst;
    }


    public void dfs(TreeNode target,int k) {
        if(target!=null){
            if(visited.contains(target)) {
                return;
            }
            visited.add(target);
            if(k == distance) {
                rst.add(target.val);
                return;
            }
            //left
            if(target.left!=null){
                dfs(target.left, k + 1);
            }
            //right
            if(target.right!=null){
                dfs(target.right, k + 1);
            }
            //parent
            if(hashMap.containsKey(target)){
                TreeNode parent = hashMap.get(target);
                dfs(parent,k+1);
            }
        }
    }

    public void buildParMap(TreeNode child,TreeNode par) {
        if(child!=null){
            hashMap.put(child,par);
            buildParMap(child.left,child);
            buildParMap(child.right,child);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p1 = new TreeNode(5);
        TreeNode p2= new TreeNode(1);
        TreeNode p3 =new TreeNode(6);
        TreeNode p4 = new TreeNode(2);
        TreeNode p5 = new TreeNode(0);
        TreeNode p6 = new TreeNode(8);
        TreeNode p7 = new TreeNode(7);
        TreeNode p8 = new TreeNode(4);
        root.left =p1;
        root.right=p2;
        p1.left=p3;
        p1.right=p4;
        p2.left=p5;
        p2.right=p6;
        p4.left=p7;
        p4.right=p8;
        tree863 obj = new tree863();
        List<Integer> integers = obj.distanceK(root, p1, 2);
        System.out.println(integers.toString());
    }
}
