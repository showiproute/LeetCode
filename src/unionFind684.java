import java.util.Arrays;

public class unionFind684 {

    public class UF {
        public int counts;
        public int[] parents;

        public UF(int n) {
            this.counts = n;
            this.parents = new int[n+1];
            for(int i= 1 ;i<=n;i++){
                parents[i] = i;
            }
        }

        public void union(int p,int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return;
            parents[rootQ] = rootP;
            counts--;
        }

        public boolean isConnected(int p,int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        public int find(int p) {
            while (parents[p] != p) {
                parents[p] = parents[parents[p]];
                p = parents[p];
            }

            return p;
        }

        public int count(){
            return this.counts;
        }
    }
    //[1,2], [2,3], [3,4], [1,4], [1,5]
    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0 ) return new int[]{};
        UF uf = new UF(edges.length);
        for(int i = 0;i<edges.length;i++){
            int par = edges[i][0];
            int child = edges[i][1];
            if(uf.isConnected(par,child)) return edges[i];
            uf.union(par,child);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[][] edges= {
                {1,2},
                {2,3},
                {3,4},
                {1,4},
                {1,5}
        };
        unionFind684 obj = new unionFind684();
        int[] redundantConnection = obj.findRedundantConnection(edges);
        System.out.println(Arrays.toString(redundantConnection));
    }

}
