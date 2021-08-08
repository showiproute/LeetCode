import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class dfs802 {

    //输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
    //输出：[2,4,5,6]
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> rst = new ArrayList<>();
        int[] color = new int[graph.length];
        for(int i = 0;i<graph.length;i++){
            if(dfs(graph,color,i)){
                rst.add(i);
            }
        }
        return rst;
    }

    public boolean dfs(int[][] graph,int[] color,int index) {
        if(color[index] != 0) {
            return color[index] == 2;
        }
        color[index] = 1;
        for(int i = 0;i<graph[index].length;i++){
            if(!dfs(graph,color,graph[index][i])) {
                return false;
            }
        }
        color[index] = 2;
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
        dfs802 obj = new dfs802();
        List<Integer> integers = obj.eventualSafeNodes(arr);
        System.out.println(integers.toString());
    }

}
