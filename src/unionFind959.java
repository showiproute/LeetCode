public class unionFind959 {

    public class UF {
        public int counts;
        public int[] parents;
        public UF(int n) {
            this.counts = n;
            this.parents = new int[n];
            for(int i = 0;i<n;i++){
                parents[i] = i;
            }
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

        public void union(int p,int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return;

            parents[rootP] = rootQ;
            counts--;
        }
    }

    public int regionsBySlashes(String[] grid) {
        int length = grid.length;
        int N = 4*length*length;
        UF uf = new UF(N);
        for(int i = 0;i<length;i++){
            char[] array = grid[i].toCharArray();
            for(int j = 0;j<length;j++){
                int index = 4*(i*length+j);
                char c = array[j];
                if(c == '/') {
                    uf.union(index,index+3);
                    uf.union(index+1,index+2);
                }else if(c == '\\'){
                    uf.union(index,index+1);
                    uf.union(index+2,index+3);
                }else{
                    uf.union(index,index+1);
                    uf.union(index+1,index+2);
                    uf.union(index+2,index+3);
                }

                if(j+1 < length) {
                    uf.union(index+1,4*(i*length+j+1)+3);
                }
                if(i+1 < length) {
                    uf.union(index+2,4*((i+1)*length+j));
                }
            }
        }

        return uf.counts;
    }

    //[
//  "/\\",
//  "\\/"
//]
    public static void main(String[] args) {
        String[] arr = {"/\\","\\/"};
        unionFind959 obj = new unionFind959();
        int i = obj.regionsBySlashes(arr);
        System.out.println(i);
    }



}
