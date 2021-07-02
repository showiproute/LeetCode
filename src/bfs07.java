import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class bfs07 {


    public int numWays(int n, int[][] relation, int k) {
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for(int i = 0;i<relation.length;i++){
            if(hashMap.containsKey(relation[i][0])) {
                ArrayList<Integer> temp = hashMap.get(relation[i][0]);
                temp.add(relation[i][1]);
                hashMap.put(relation[i][0],temp);
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(relation[i][1]);
                hashMap.put(relation[i][0],temp);
            }
        }
        if(k == 1) {
            if(hashMap.containsKey(0)) {
                ArrayList<Integer> temp = hashMap.get(0);
                if(temp.contains(n-1)) return 1;
            }
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        //root
        for(Integer root : hashMap.get(0)) {
            queue.offer(root);
        }
        k--;
        while (k!=1) {
            int size = queue.size();
            for(int i = 0;i<size;i++){
                Integer root = queue.poll();
                if(!hashMap.containsKey(root)) {
                    continue;
                }
                for(Integer nei : hashMap.get(root)){
                    queue.offer(nei);
                }
            }
            k--;
        }
        int rst = 0;
        while (!queue.isEmpty()) {
            Integer root = queue.poll();
            if(!hashMap.containsKey(root)){
                continue;
            }
            ArrayList<Integer> temp = hashMap.get(root);
            if(temp.contains(n-1)){
                rst++;
            }
        }

        return rst;
    }

//8
//[[2,3],[4,1],[4,5],[2,0],[7,1],[1,7],[5,6],[6,1],[6,7],[3,6],[2,7],[7,5],[1,3],[2,1],[4,6],[7,6],[0,2],[3,1],[4,0],[5,1],[3,0],[5,4]]
//1
    public static void main(String[] args) {
        bfs07 obj = new bfs07();
        int[][] relation = {
                {2,3},
                {4,1},
                {4,5},
                {2,0},
                {7,1},
                {1,7},
                {5,6},
                {6,1},
                {6,7},
                {3,6},
                {2,7},
                {7,5},
                {1,3},
                {2,1},
                {4,6},
                {7,6},
                {0,2},
                {3,1},
                {4,0},
                {5,1},
                {3,0},
                {5,4}
        };
        int i = obj.numWays(8, relation, 1);
        System.out.println(i);
    }
}
