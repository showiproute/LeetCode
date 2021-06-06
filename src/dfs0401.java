import java.util.ArrayList;
import java.util.HashMap;

public class dfs0401 {


    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if(graph == null || graph.length  ==0 || n == 0) return true;
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int[] ints : graph) {
            int x = ints[0];
            int y = ints[1];
            if (hashMap.containsKey(x)) {
                ArrayList<Integer> arrayList = hashMap.get(x);
                if (!arrayList.contains(y)) {
                    arrayList.add(y);
                    hashMap.put(x, arrayList);
                }
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(y);
                hashMap.put(x, arrayList);
            }
        }
        return dfs(hashMap, start, target, new ArrayList<>());
    }

    public boolean dfs(HashMap<Integer,ArrayList<Integer>> hashMap,int start,int end,ArrayList<Integer> visited){
        if(!hashMap.containsKey(start) || visited.contains(start)){
            return false;
        }
        visited.add(start);
        ArrayList<Integer> arrayList = hashMap.get(start);
        for(Integer val : arrayList) {
            if(val == end) return true;
            if(dfs(hashMap,val,end,visited)){
                return true;
            }
        }

        return false;
    }


    // 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1],
    // [1, 3], [1, 4],
    // [1, 3], [2, 3], [3, 4]], start = 0, target = 4
    // 输出 true
    public static void main(String[] args) {
        int[][] graph = {
                {0,1},
                {0,2},
                {0,4},
                {0,4},
                {0,1},
                {1,3},
                {1,4},
                {1,3},
                {2,3},
                {3,4}
        };
        dfs0401 obj = new dfs0401();
        boolean whetherExistsPath = obj.findWhetherExistsPath(5, graph, 0, 4);
        System.out.println(whetherExistsPath);
    }

}
