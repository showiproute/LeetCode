import java.util.HashMap;
import java.util.HashSet;

public class LRUCache {

    public class DListNode {
        int key;
        int val;
        DListNode next;
        DListNode prev;
        public DListNode(int x,int y){
            this.key =x;
            this.val =y;
        }
    }

    public int size ;
    public int length = 0;
    DListNode head = new DListNode(-1,-1);
    DListNode tail = new DListNode(-1,-1);
    public HashMap<Integer,DListNode> hashMap = new HashMap<>();
    public LRUCache(int x) {
        this.size = x;
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key,int value) {
        DListNode node = hashMap.get(key);
        if(node!=null) {
            node.val = value;
            deleteNode(node);
            moveToHead(node);
        }else{
            if(length >= size) {
                removeTail();
            }
            node = new DListNode(key,value);
            moveToHead(node);
            hashMap.put(key,node);
            length++;
        }
    }

    public int get(int x) {
        DListNode node = hashMap.get(x);
        if(node!=null) {
            deleteNode(node);
            moveToHead(node);
            return node.val;
        }else{
            return -1;
        }
    }

    public void deleteNode(DListNode node) {
//        System.out.println("node"+node);
//        System.out.print("node.prev"+node.prev);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //移动到头节点
    public void moveToHead(DListNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    //删除尾节点
    public void removeTail() {
        DListNode last = tail.prev;
        last.prev.next = tail;
        tail.prev = last.prev;
        hashMap.remove(last.key);
        length--;
    }

    public void printList(){
        DListNode p = head;
        while(p!=null) {
            System.out.println(p.val);
            p= p.next;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(2,1);
        System.out.println(cache.hashMap.toString());
        System.out.println(cache.get(2));
        cache.put(3,2);
        System.out.println(cache.hashMap.toString());
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}
