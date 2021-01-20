import java.util.HashMap;
import java.util.Map;

public class unionFind1319 {

    public class UF {
        public int counts;
        public int[] parents;
        public UF(int n){
            this.counts = n;
            this.parents = new int[n];
            for(int i = 0;i<n;i++){
                parents[i] = i;
            }
        }

        public int find(int p) {
            if(parents[p] != p) {
                int par = parents[p];
                parents[p] = parents[find(par)];
            }

            return parents[p];
        }

        public boolean isConnected(int p ,int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        public void union(int p,int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return;
            parents[rootP] = rootQ;
            counts--;
        }
    }


    public int makeConnected(int n, int[][] connections) {
        if(connections == null || connections.length ==0 ) return 0;
        UF uf = new UF(n);
        int length = connections.length;
        for(int i =0;i<length;i++){
            uf.union(connections[i][0],connections[i][1]);
        }

        if(uf.counts == 1) return 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int used = 0;
        for(int i = 0;i<n;i++){
            int root = uf.find(i);
            hashMap.put(root,hashMap.getOrDefault(root,0)+1);
        }
        for(Map.Entry<Integer,Integer> keyVal : hashMap.entrySet()) {
            used+=keyVal.getValue()-1;
        }

        int rest = length-used;
        if(rest < uf.counts-1) return -1;
        return uf.counts-1;
    }

//输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
//输出：-1
//解释：线缆数量不足。
    public static void main(String[] args) {
        int[][]  conn ={
                {0,1},
                {0,2},
                {0,3},
                {1,2},
//                {1,3}
        };
        unionFind1319 obj = new unionFind1319();
        int i = obj.makeConnected(6, conn);
        System.out.println(i);
    }
}
