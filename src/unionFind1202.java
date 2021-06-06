import java.util.*;

public class unionFind1202 {
    public class UF {
        public int counts;
        public int[] parents;
        public int[] rank;
        public UF(int n){
            this.counts = n;
            this.parents = new int[n];
            this.rank = new int[n];
            for(int i = 0;i<n;i++){
                parents[i] = i;
                rank[i] = 1;
            }
        }

        public void union(int p,int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return;
            if(rank[rootP] == rank[rootQ]) {
                rank[rootP]++;
                parents[rootQ] =rootP;
            }else if(rank[rootP] > rank[rootQ]) {
                rank[rootP]+=rank[rootQ];
                parents[rootQ] = rootP;
            }else{
                rank[rootQ]+=rank[rootP];
                parents[rootP] = rootQ;
            }
            counts--;
        }

        public int find(int p){
            if(parents[p] != p) {
                parents[p] = find(parents[p]);
            }

            return parents[p];
        }

        public boolean isConnected(int p,int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

    }

    ////    输入：s = "dcab", pairs = [[0,3],[1,2]][0,2]
    ////    输出："abcd"
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(pairs== null || pairs.size() == 0) return s;
        UF uf = new UF(s.length());

        for(List<Integer> pair : pairs) {
            uf.union(pair.get(0),pair.get(1));
        }

        HashMap<Integer,PriorityQueue<Character>> hashMap = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            int root = uf.find(i);
            if(hashMap.containsKey(root)) {
                hashMap.get(root).offer(s.charAt(i));
            }else{
                PriorityQueue<Character> queue = new PriorityQueue<>();
                queue.offer(s.charAt(i));
                hashMap.put(root,queue);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            int root = uf.find(i);
            sb.append(hashMap.get(root).poll());
        }

        return sb.toString();
    }

    //输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
    //输出："abcd"
    public static void main(String[] args) {
        unionFind1202 obj = new unionFind1202();
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> p1 = new ArrayList<>();
        p1.add(0);
        p1.add(3);
        rst.add(p1);
        List<Integer> p2 = new ArrayList<>();
        p2.add(1);
        p2.add(2);
        rst.add(p2);
//        List<Integer> p3 = new ArrayList<>();
//        p3.add(0);
//        p3.add(2);
//        rst.add(p3);
        String dcab = obj.smallestStringWithSwaps("dcab", rst);
        System.out.println(dcab);
    }
}