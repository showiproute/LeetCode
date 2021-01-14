public class unionFind990 {

    public class UF{
        public int counts;
        public int[] parents;

        public UF(int n) {
            this.counts = n;
            this.parents = new int[n];
            for(int i =0 ;i<n;i++){
                parents[i] = i;
            }
        }

        public boolean isConnected(int p,int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return  rootP == rootQ;
        }

        public int find(int p) {
            while (parents[p] != p) {
                parents[p] = parents[parents[p]];
                p = parents[p];
            }

            return p;
        }

        public void union(int p ,int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return;
            parents[rootP] = rootQ;
            counts--;
        }

    }

    //["a==b","b!=c","c==a"]
    public boolean equationsPossible(String[] equations) {
       if(equations == null || equations.length ==0) return true;
       UF uf = new UF(26);
       for(int i =0 ;i<equations.length;i++){
           if(equations[i].charAt(1) == '=') {
               int p = equations[i].charAt(0) - 'a';
               int q = equations[i].charAt(3) - 'a';
               uf.union(p,q);
           }
       }

       for(int i =0;i<equations.length;i++){
           if(equations[i].charAt(1) == '!'){
               int p = equations[i].charAt(0) - 'a';
               int q = equations[i].charAt(3) - 'a';
               if(uf.isConnected(p,q)) {
                   return false;
               }
           }
       }

       return true;
    }

    public static void main(String[] args) {
        unionFind990 obj = new unionFind990();
        String[] arr = {"c==c","b==d","x!=z"};

        boolean b = obj.equationsPossible(arr);
        System.out.println(b);
    }


}
