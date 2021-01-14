import java.util.Arrays;

public class UnionFind {

    //记录连通量
    public int counts;
    //记录节点数量
    public int[] size;
    //记录父亲节点
    public int[] parent;

    public UnionFind(int n){
        this.counts = n;
        this.size = new int[n];
        this.parent = new int[n];
        for(int i = 0;i<n;i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    private void union(int p,int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return;
        if(size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP]+=size[rootQ];
        }else{
            parent[rootP] = rootQ;
            size[rootQ]+=size[rootP];
        }
        counts--;
    }

    //返回某个节点的root根节点
    private int find(int p) {
        while(parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }

    private boolean isConnected(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    private int count() {
        return this.counts;
    }

    public static void main(String[] args) {
        UnionFind obj = new UnionFind(10);
        //test
        System.out.println(Arrays.toString(obj.parent));
        System.out.println(Arrays.toString(obj.size));
        //test
        obj.union(1,2);
        System.out.println(Arrays.toString(obj.parent));
        System.out.println(Arrays.toString(obj.size));
        System.out.println(obj.isConnected(1,3));
    }
}
