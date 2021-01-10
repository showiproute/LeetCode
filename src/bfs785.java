import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class bfs785 {

    public int UNCOLORED = 0;
    public int RED = 1;
    public int GREEN = 2;

    public boolean isBipartite(int[][] graph) {
        if(graph == null || graph.length ==0 ) return true;
        int length = graph.length;
        int[] color = new int[length];

        for(int i =0 ;i<length;i++){
            if(color[i] == UNCOLORED) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = RED;
                while(!queue.isEmpty()) {
                    int size = queue.size();
                    for(int j = 0;j<size;j++){
                        Integer node = queue.poll();
                        int neiColor = color[node] == RED ? GREEN : RED;
                        for(int k = 0;k<graph[node].length;k++){
                            if(color[graph[node][k]] != UNCOLORED){
                                if(color[graph[node][k]] != neiColor) {
                                    return false;
                                }
                            }else{
                                color[graph[node][k]] = neiColor;
                                queue.offer(graph[node][k]);
                            }
                        }
                    }
                }
            }
        }


        return true;
    }

    public static void main(String[] args) {
//        [[1],[0,3],[3],[1,2]]
        int[][] matrix = {
                {1,2,3},
                {0,2},
                {0,1,3},
                {0,2}
        };
        bfs785 obj = new bfs785();
        boolean bipartite = obj.isBipartite(matrix);
        System.out.println(bipartite);
    }
}
