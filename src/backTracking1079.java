import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class backTracking1079 {

    public HashSet<String> rst = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        if(tiles == null || tiles.length() ==0 ){
            return 0;
        }

        char[] charArray = tiles.toCharArray();
        Arrays.sort(charArray);
        boolean[] visited = new boolean[tiles.length()];

        dfs(charArray,new StringBuilder(),visited);

        return rst.size()-1;
    }

    public void dfs(char[] tiles,StringBuilder sb,boolean[] visited) {
        rst.add(sb.toString());
        for(int i = 0;i <tiles.length;i++){
            if(!visited[i]) {
                visited[i] = true;
                sb.append(tiles[i]);
                dfs(tiles,sb,visited);
                sb.deleteCharAt(sb.length()-1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) {

        backTracking1079 obj = new backTracking1079();
        int aab = obj.numTilePossibilities("AAB");
        System.out.println(aab);
        System.out.println(obj.rst.toString());
    }


}
