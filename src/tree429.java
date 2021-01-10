import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class tree429 {

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> rst = new ArrayList<>();
        if(root == null) return rst;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<size;i++){
                Node node = queue.poll();
                for(Node child : node.children) {
                    queue.offer(child);
                }
                temp.add(node.val);
            }
            rst.add(temp);
        }

        return rst;
    }
}
