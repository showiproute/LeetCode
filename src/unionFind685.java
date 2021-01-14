import java.util.Arrays;

public class unionFind685 {

    public class UF {
        public int counts;
        public int[] parents;

        public UF(int n) {
            this.counts = n;
            this.parents = new int[n];
            for(int i= 1 ;i<n;i++){
                parents[i] = i;
            }
        }

        public void union(int q,int p) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return;
            parents[rootP] = rootQ;
            counts--;
        }

        public int find(int p) {
            while (parents[p] != p) {
                parents[p] = parents[parents[p]];
                p = parents[p];
            }

            return p;
        }

        public boolean isConnected(int p,int q) {
            int rootP = find(p);
            int rootQ = find(q);

            return rootP == rootQ;
        }

        public int count(){
            return this.counts;
        }

    }
    //[[2,1],[3,1],[4,2],[1,4]]
    //这道题和684不太一样的是，684是无向图，可以想到用并查集来做，
    //685是有向图，运用入度的概念，可以联想到用并查集来做

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int length = edges.length;

        int[] inDegree = new int[length+1];
        for(int i=0;i<length;i++){
            inDegree[edges[i][1]]++;
        }
        //先找入度为2的
        for(int i = length-1;i>=0;i--){
            if(inDegree[edges[i][1]] == 2) {
                if(!canBecomeCircle(i,edges,length)) {
                    return edges[i];
                }
            }
        }

        //再找入度为1的
        for(int i = length-1;i>=0;i--){
            if(inDegree[edges[i][1]] == 1) {
                if(!canBecomeCircle(i,edges,length)){
                    return edges[i];
                }
            }
        }

        return  new int[]{};
    }

    public boolean canBecomeCircle(int removeIndex,int[][] edges,int length) {
        UF obj = new UF(length+1);
        for(int i = length-1;i>=0;i--){
            if(i == removeIndex) {
                continue;
            }
            if(obj.isConnected(edges[i][0],edges[i][1])) {
                return true;
            }
            obj.union(edges[i][0],edges[i][1]);
        }

        return false;
    }


    //[[2,1],[3,1],[4,2],[1,4]]
    public static void main(String[] args) {
        int[][] edges = {
                {1,2},
                {2,3},
                {3,4},
                {4,1},
                {1,5}
        };
        unionFind685 obj = new unionFind685();
        int[] redundantDirectedConnection = obj.findRedundantDirectedConnection(edges);
        System.out.println(Arrays.toString(redundantDirectedConnection));
    }
}
