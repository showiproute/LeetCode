public class offer36 {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


    public Node first = null;
    public Node prev = null;

    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        inOrder(root);
        first.left = prev;
        prev.right = first;

        return first;
    }

    public void inOrder(Node root) {
        if(root != null){
            inOrder(root.left);

            if(first == null) {
                first = root;
            }
            if(prev == null) {
                prev = root;
            }else{
                root.left = prev;
                prev.right = root;
                prev = root;
            }
            inOrder(root.right);
        }
    }


    public static void main(String[] args) {
        Node root = new Node(4);
        Node p2 = new Node(2);
        Node p5= new Node(5);
        Node p1= new Node(1);
        Node p3 = new Node(3);
        root.left= p2;
        root.right=p5;
        p2.left=p1;
        p2.right=p3;
        offer36 obj = new offer36();
        Node node = obj.treeToDoublyList(root);
        System.out.println(node.val);
        System.out.println(node.right.val);
        System.out.println(node.right.right.val);
        System.out.println(node.right.right.right.val);
        System.out.println(node.right.right.right.right.val);
    }
}
