import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class unionFind1202 {

    public class UF {

        public int counts;
        public int[] parents;
        public UF(int n) {
            this.parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
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

        public void union(int p,int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return;
            if(rootP <= rootQ) {
                parents[rootQ] = rootP;
            }else{
                parents[rootP] = rootQ;
            }
            counts--;
        }

        public int counts(){
            return this.counts;
        }

    }

    ////    输入：s = "dcab", pairs = [[0,3],[1,2]]
    ////    输出："bacd"
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(s == null || s.length() == 0 || pairs.size() == 0) return s;
        UF uf = new UF(26);
        uf.counts = s.length();
        for(List<Integer> pair : pairs) {
            int p = s.charAt(pair.get(0)) - 'a';
            int q = s.charAt(pair.get(1)) - 'a';
            uf.union(p,q);
        }
        //test
        System.out.println(Arrays.toString(uf.parents));

        //全连通
        if(uf.counts == 1) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            StringBuilder sb = new StringBuilder();
            for(char item : array) {
                sb.append(item);
            }
            return sb.toString();
        }
        //没有全连通
        ArrayList<Character> rst = new ArrayList<>();
        for(int i =0 ;i<s.length();i++) {

        }

        return "";
    }


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
