import java.util.*;

public class dfs207 {

    //bfs
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;
//        //visited
//        HashSet<Integer> visited = new HashSet<>();
//        //入度表
//        int[] inTable = new int[numCourses];
//        //邻接表初始化操作
//        HashMap<Integer,ArrayList<Integer>> adjMap = new HashMap<>();
//        for(int j = 0;j<prerequisites.length;j++){
//            if(adjMap.containsKey(prerequisites[j][1])){
//                ArrayList<Integer> arrayList = adjMap.get(prerequisites[j][1]);
//                arrayList.add(prerequisites[j][0]);
//                adjMap.put(prerequisites[j][1],arrayList);
//            }else{
//                ArrayList<Integer> arrayList = new ArrayList<>();
//                arrayList.add(prerequisites[j][0]);
//                adjMap.put(prerequisites[j][1],arrayList);
//            }
//            inTable[prerequisites[j][0]]++;
//        }
//        //Queue
//        Queue<Integer> queue = new LinkedList<>();
//        for(int i =0;i<numCourses;i++){
//            if(inTable[i] == 0) {
//                queue.offer(i);
//            }
//        }
//
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            for(int i =0;i<size;i++){
//                Integer node = queue.poll();
//                visited.add(node);
//                if(!adjMap.containsKey(node)){
//                    continue;
//                }
//                ArrayList<Integer> arrayList = adjMap.get(node);
//                for(int j=0;j<arrayList.size();j++){
//                    inTable[arrayList.get(j)]--;
//                    if(inTable[arrayList.get(j)]==0){
//                        queue.offer(arrayList.get(j));
//                    }
//                }
//            }
//        }
//
//        return visited.size() == numCourses;
//    }

    //dfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;
        //fsmTable
        int[] fsmTable = new int[numCourses];
        //领接表
        List<List<Integer>> adjTable = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adjTable.add(new ArrayList<>());
        }
        for(int i = 0;i<prerequisites.length;i++){
            adjTable.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i = 0;i<numCourses;i++){
            boolean dfs = dfs(i, adjTable, fsmTable);
            if(!dfs){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int node,List<List<Integer>> adjTable,int[] fsmTable) {
        if(fsmTable[node] == 1) return false;
        if(fsmTable[node] == -1 ) return true;
        fsmTable[node] = 1;
        for(Integer item : adjTable.get(node)){
            if(!dfs(item,adjTable,fsmTable)){
                return false;
            }
        }
        fsmTable[node] = -1;
        return true;
    }




    public static void main(String[] args) {
        int[][] arr = {
                {1,0}
        };
        dfs207 obj = new dfs207();
        boolean b = obj.canFinish(3, arr);
        System.out.println(b);

    }
}
