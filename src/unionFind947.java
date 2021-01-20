import java.util.*;

public class unionFind947 {

    //输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
    //输出：5
    public class UF {
        public int counts;
        public HashMap<Integer,Integer> parents;
        public UF(){
            this.counts = 0;
            this.parents = new HashMap<>();
        }
        public void union(int p ,int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return;
            parents.put(rootP,rootQ);
            counts--;
        }

        public boolean isConnected(int p,int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        public int find(int p) {
            if(!parents.containsKey(p)) {
                parents.put(p,p);
                counts++;
            }
            if(p!=parents.get(p)) {
                int par = parents.get(p);
                parents.put(p,find(par));
            }

            return parents.get(p);
        }

        public int getCounts(){
            return this.counts;
        }
    }


    public int removeStones(int[][] stones) {
        if(stones == null || stones.length ==0) return 0;
        UF uf = new UF();
        for(int[] stone : stones) {
            uf.union(stone[0]+10001,stone[1]);
        }

        return stones.length-uf.counts;
    }

    //[[0,1],[0,2],[4,3],[2,4],[0,3],[1,1]]
    public static void main(String[] args) {
        int[][] arr = {
                {0,1},
                {0,2},
                {4,3},
                {2,4},
                {0,3},
                {1,1},
        };

        unionFind947 obj = new unionFind947();
        int i = obj.removeStones(arr);
        System.out.println(i);
    }
}