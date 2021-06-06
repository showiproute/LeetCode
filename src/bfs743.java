import java.util.*;

public class bfs743 {

    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,HashMap<Integer,Integer>> hashMap = new HashMap<>();
        for(int i = 0;i<times.length;i++){
            int src = times[i][0];
            int dst = times[i][1];
            int w = times[i][2];
            if(hashMap.containsKey(src)) {
                HashMap<Integer, Integer> temp = hashMap.get(src);
                temp.put(dst,w);
                hashMap.put(src,temp);
            }else{
                HashMap<Integer,Integer> temp = new HashMap<>();
                temp.put(dst,w);
                hashMap.put(src,temp);
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        int sumLength = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        while (!queue.isEmpty()) {
            //test
//            System.out.println(queue.toString());
//            System.out.println("visited"+visited.toString());
            int size = queue.size();
            int maxLength = 0;
            for(int i = 0;i<size;i++){
                Integer src = queue.poll();
                if(visited.contains(src)) {
                    continue;
                }
                visited.add(src);
                if(!hashMap.containsKey(src)) {
                    continue;
                }
                HashMap<Integer, Integer> map = hashMap.get(src);
                for(Map.Entry<Integer,Integer> keyVal : map.entrySet()) {
                    maxLength = Math.max(maxLength,keyVal.getValue());
                    Integer dst = keyVal.getKey();
                    queue.offer(dst);
                }
            }
            sumLength += maxLength;
        }
        //test
//        System.out.println("final"+visited.toString());

        if(visited.size() == n) {
            return sumLength;
        }else{
            return -1;
        }
    }

//   输入：times = [[1,2,1]], n = 2, k = 1

    public static void main(String[] args) {
        int[][] times = {
                {1,2,1},
        };
        bfs743 obj = new bfs743();
        int i = obj.networkDelayTime(times, 2, 2);
        System.out.println(i);
    }
}
