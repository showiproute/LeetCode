import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class unionFind1584 {

    public class UF{
        public int counts;
        public HashMap<Integer,Integer> hashMap;

        public UF(){
            this.counts = 0;
            this.hashMap = new HashMap<>();

        }

        public void union(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return;
            hashMap.put(rootP,rootQ);
            counts--;
            return;
        }

        public boolean isConnected(int p,int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        public int find(int p) {
            if(!hashMap.containsKey(p)) {
                hashMap.put(p,p);
                counts++;
                return p;
            }

            if(hashMap.get(p) != p) {
                Integer par = hashMap.get(p);
                hashMap.put(p,find(par));
            }

            return hashMap.get(p);
        }
    }

    public class edge{
        public int x;
        public int y;
        public int length;
        public edge(int x,int y,int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }

        @Override
        public String toString() {
            return "edge{" +
                    "x=" + x +
                    ", y=" + y +
                    ", length=" + length +
                    '}';
        }
    }


    public int getLength(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }


    public int minCostConnectPoints(int[][] points) {
        if(points == null || points.length ==0 ) return 0;
        //data
        ArrayList<edge> arrayList = new ArrayList<>();
        for(int i = 0;i<points.length;i++){
            for(int j =i+1;j<points.length;j++){
                int length = getLength(points[i][0], points[i][1], points[j][0], points[j][1]);
                edge edge = new edge(i, j, length);
                arrayList.add(edge);
            }
        }
        arrayList.sort(new Comparator<edge>() {
            @Override
            public int compare(edge o1, edge o2) {
                return o1.length - o2.length;
            }
        });

        //test
        UF uf = new UF();
        int result = 0;
        for(edge edge : arrayList) {
            int x = edge.x;
            int y = edge.y;
            int length = edge.length;
            if(uf.isConnected(x,y)) continue;
            else{
                uf.union(x,y);
                result+=length;
            }
        }

        return result;
    }


    //输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
    //输出：20
    public static void main(String[] args) {
        int[][] points = {
                {0,0},
                {2,2},
                {3,10},
                {5,2},
                {7,0}
        };
        unionFind1584 obj = new unionFind1584();
        int i = obj.minCostConnectPoints(points);
        System.out.println(i);
    }


}
