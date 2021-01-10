import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class dfs1619 {

    public int[] pondSizes(int[][] land) {
        if(land == null || land.length ==0 )return new int[]{};
        boolean[][] visited = new boolean[land.length][land[0].length];
        ArrayList<Integer> rst = new ArrayList<>();
        for(int i = 0;i<land.length;i++){
            for(int j = 0;j<land[i].length;j++){
                if(land[i][j] == 0 && !visited[i][j]) {
                    int value = dfs(land, i, j, visited);
                    rst.add(value);
                }
            }
        }
        Collections.sort(rst);
        int[] retArr = new int[rst.size()];
        for(int i = 0;i<rst.size();i++){
            retArr[i] = rst.get(i);
        }

        return retArr;
    }

    public int dfs(int[][] land,int i ,int j,boolean[][] visited) {
        if(i<0 || i>= land.length || j<0 || j>=land[0].length || land[i][j] != 0 || visited[i][j]) return 0;
        visited[i][j] = true;

        //8个角度
        return 1+dfs(land,i-1,j-1,visited)+dfs(land,i-1,j,visited)+
                dfs(land,i-1,j+1,visited)+dfs(land,i,j-1,visited)+
                dfs(land,i,j+1,visited)+dfs(land,i+1,j-1,visited)+
                dfs(land,i+1,j,visited)+dfs(land,i+1,j+1,visited);
    }

    public static void main(String[] args) {
        //[
        //  [0,2,1,0],
        //  [0,1,0,1],
        //  [1,1,0,1],
        //  [0,1,0,1]
        //]
        dfs1619 obj = new dfs1619();
        int[][] arr = {
                {0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}
        };
        int[] ints = obj.pondSizes(arr);
        System.out.println(Arrays.toString(ints));
        int dfs = obj.dfs(arr, 0, 0, new boolean[arr.length][arr[0].length]);
        System.out.println(dfs);
    }
}
