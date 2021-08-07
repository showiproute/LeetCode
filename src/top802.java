import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class top802 {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> rst = new ArrayList<>();
        for(int i = 0;i<graph.length;i++){
            if(graph[i].length == 0) {
                rst.add(i);
                continue;
            }
            HashSet<Integer> visited = new HashSet<>();
            if(dfs(i,graph,visited)){
                rst.add(i);
            }
        }

        return rst;
    }

    public boolean dfs(int src,int [][]graph,HashSet<Integer> visited) {
        if(visited.contains(src)) return false;
        for(int i = 0;i<graph[i].length;i++){
            int val = graph[src][i];
            visited.add(val);
            if(dfs(val,graph,visited)){
                return true;
            }
            visited.remove(val);
        }

        return true;
    }

    //输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
    //输出：[2,4,5,6]
    public static void main(String[] args) {
        int[][] arr = {
                {1,2},
                {2,3},
                {5},
                {0},
                {5},
                {},
                {}
        };
        top802 obj = new top802();
        List<Integer> integers = obj.eventualSafeNodes(arr);
        System.out.println(integers.toString());
    }

}
