import java.util.*;

public class bfs210 {

    //bfs
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <=0 ) return new int[]{};
        //case
        if(numCourses == 1 && prerequisites.length ==0) {
            return new int[]{0};
        }

        //rst
        ArrayList<Integer> rst = new ArrayList<>();
        //visited
        HashSet<Integer> visited = new HashSet<>();
        //入度table
        int[] inSideTable = new int[numCourses];
        //adjTable
        ArrayList<ArrayList<Integer>> adjTable = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adjTable.add(new ArrayList<>());
        }
        for(int i = 0;i<prerequisites.length;i++){
            adjTable.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inSideTable[prerequisites[i][0]]++;
        }
        //queue
        Queue<Integer> queue = new LinkedList<>();
        //入度为0
        for(int i = 0;i<numCourses;i++){
            if( inSideTable[i] == 0){
                queue.offer(i);
            }
        }
        //bfs
        while(!queue.isEmpty()){
            int size = queue.size();
//            System.out.println("queue"+queue.toString());
            for(int i = 0;i<size;i++){
                Integer node = queue.poll();
                if(visited.contains(node)) {
                    return new int[]{};
                }
                visited.add(node);
                //visited
//                System.out.println("visited"+visited.toString());
                rst.add(node);
                for(Integer item : adjTable.get(node)){
                    inSideTable[item]-- ;
                    if(inSideTable[item] == 0){
                        queue.offer(item);
                    }
                }
            }
        }
        if(visited.size() != numCourses) {
            return new int[]{};
        }
        int[] retArr = new int[numCourses];
        for(int i = 0;i<rst.size();i++){
            retArr[i]=rst.get(i);
        }

        return retArr;
    }

    public static void main(String[] args) {
        //[1,0],[2,0],[3,1],[3,2]
        bfs210 obj = new bfs210();
        int[][] arr = {
//                {1,0},
//                {2,0},
//                {3,1},
//                {3,2},
//                {2,3}
        };
        int[] order = obj.findOrder(1, null);
        System.out.println(Arrays.toString(order));
    }

}
