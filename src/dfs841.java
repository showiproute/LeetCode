import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public class dfs841 {

    //[[1,3],[3,0,1],[2],[0]]
    LinkedHashMap<Integer,List<Integer>> vectors = new LinkedHashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0) return true;
        for(int i = 0;i<rooms.size();i++){
            vectors.put(i,rooms.get(i));
        }

        dfs(0);
        return visited.size() == rooms.size();
    }

    public void dfs(int index) {
        if(vectors.containsKey(index) && !visited.contains(index)) {
            visited.add(index);
            List<Integer> roomIdList = vectors.get(index);
            for(Integer roomId : roomIdList) {
                dfs(roomId);
            }
        }
    }




}
