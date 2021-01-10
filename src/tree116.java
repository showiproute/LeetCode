public class tree116 {

    class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }

    public Node connect(Node root) {
        if(root == null || root.left == null || root.right == null) return root;

        connect(root.left,root.right);
        return root;
    }

    public void connect(Node left,Node right) {
        if(left == null || right == null) return;

        left.next = right;
        connect(left.left,left.right);
        connect(right.left,right.right);
        connect(left.right,right.left);
    }


}
