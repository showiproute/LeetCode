import java.util.Arrays;

public class dfshuaxue {


    public int[][] dir = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };

    public int solution(int[][] arr){
        if(arr == null || arr.length == 0) return 0;
        int[][] visited = new int[arr.length][arr[0].length];
        int maxVal = 0;
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                if(visited[i][j] != 0) {
                    maxVal = Math.max(maxVal,visited[i][j]);
                }else{
                    int dfs = dfs(arr, visited, i, j,Integer.MAX_VALUE);
                    visited[i][j] = dfs;
                    maxVal = Math.max(maxVal,dfs);
                }
            }
        }
        //test
        for(int i =0 ;i<visited.length;i++){
            System.out.println(Arrays.toString(visited[i]));
        }
        return maxVal;
    }
    /*
4 5 3 1 2 4
7 8 4 3 2 6
8 4 1 2 3 7
 */
    public int dfs(int[][] arr,int[][] visited,int i,int j,int ori) {
        if(i<0 || i >=arr.length || j <0 || j>=arr[0].length) return 0;
        if(arr[i][j] >= ori) return 0;
        if(visited[i][j] != 0) return visited[i][j];
        for(int k = 0;k<dir.length;k++){
            int x = i+dir[k][0];
            int y = j+dir[k][1];
            int dfs = 1+dfs(arr, visited, x, y, arr[i][j]);
            visited[i][j] = Math.max(visited[i][j],dfs);
        }

        return visited[i][j];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {4,5,3,1,2,4},
                {7,8,4,3,2,6},
                {8,4,1,2,3,7}
        };
        dfshuaxue obj = new dfshuaxue();
        int solution = obj.solution(arr);
        System.out.println(solution);
    }
}
