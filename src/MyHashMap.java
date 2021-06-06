public class MyHashMap {

    public int[] map;
    public boolean[] visited;
    public MyHashMap() {
        this.map = new int[200];
        this.visited = new boolean[200];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        this.map[key] = value;
        this.visited[key] = true;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(!this.visited[key]) {
            return -1;
        }else{
            return this.map[key];
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        this.visited[key] = false;
        this.map[key] = 0;
    }

    //输入：
    //["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
    //[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
    //输出：
    //[null, null, null, 1, -1, null, 1, null, -1]
    //
    //解释：
    //MyHashMap myHashMap = new MyHashMap();
    //myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
    //myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
    //myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
    //myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
    //myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
    //myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
    //myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
    //myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,1);
        map.put(2,2);
        System.out.println(map.get(1));


    }

}
