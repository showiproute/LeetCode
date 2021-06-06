import java.util.Arrays;

public class unionFind765 {

    public class UF {
        public int counts;
        public int[] parents;
        public int[] rank;
        public UF(int n){
            this.counts = n;
            this.rank = new int[n];
            this.parents = new int[n];
            for(int i = 0;i<n;i++){
                parents[i] = i;
            }
            for(int i = 0;i<n;i++){
                rank[i] = 1;
            }
        }

        public void union(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return;
            if(rank[rootP] == rank[rootQ]) {
                rank[rootP]++;
                parents[rootQ] = rootP;
            }else if(rank[rootP] > rank[rootQ]){
                rank[rootP] +=rank[rootQ];
                parents[rootQ] = rootP;
            }else{
                rank[rootQ] +=rank[rootP];
                parents[rootP] = rootQ;
            }
            counts--;
        }

        public int find(int p) {
            if(parents[p] != p){
                int root = parents[p];
                parents[p] = parents[find(root)];
            }

            return parents[p];
        }

        public boolean isConnected(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
    }
    public int minSwapsCouples(int[] row) {
        if(row == null || row.length ==0) return 0;
        int len = row.length/2;
        UF uf = new UF(len);
        for(int i = 0;i<row.length;i+=2){
            int a = row[i]/2;
            int b = row[i + 1]/2;
            uf.union(a,b);
        }

        int cnts =0 ;
        int[] parents = uf.parents;
        for(int i = 0;i<parents.length;i++){
            if(parents[i] != i) {
                cnts++;
            }
        }
        //test
        System.out.println(Arrays.toString(parents));

        return cnts;
    }
    //输入: row = [0, 2, 1, 3]
    //输出: 1
    //解释: 我们只需要交换row[1]和row[2]的位置即可。
        //0 1 , 2 3 , 4 5
        // 01 , 3,5,2,4
    //[1,4,0,5,8,7,6,3,2,9]
    //

    public static void main(String[] args) {
        unionFind765 obj = new unionFind765();
        int[] rows = {1,4,0,5,8,7,6,3,2,9};
        int i = obj.minSwapsCouples(rows);
        System.out.println(i);
    }
}
