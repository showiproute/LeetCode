public class MyHashSet {
    int[] set;
    boolean[] visited;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.set = new int[1000001];
        this.visited = new boolean[1000001];
    }
    public void add(int key) {
        this.set[key] = key;
        this.visited[key] = true;
    }

    public void remove(int key) {
        this.set[key] = 0;
        this.visited[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(visited[key] ) {
            return true;
        }else{
            return false;
        }
    }

}
