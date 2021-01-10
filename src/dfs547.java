import java.util.Arrays;

public class dfs547 {

    public int[][] M;
    public boolean[][] visited;
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0) return 0;
        this.M = M;
        this.visited = new boolean[M.length][M[0].length];
        int counts = 0;
        for(int i = 0;i<M.length;i++){
            for(int j = 0;j<M[0].length;j++){
                if(M[i][j] == 1 && !visited[i][j]) {
                    dfs(i,j);
                    counts++;
                    //test
//                    for(int k = 0;k<visited.length;k++){
//                        System.out.println(Arrays.toString(visited[k]));
//                    }
//                    System.out.println("=============");
                }
            }
        }

        return counts;
    }


    public void dfs(int i,int j){
        if(i<0 || i>=M.length || j>=M[0].length || visited[i][j]) return;
        visited[i][j] = true;
        for(int k = 0;k<M[i].length;k++){
            if(M[i][k] != 0) {
                visited[i][k] = true;
                dfs(k,i);
            }
        }
    }

    //[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
    public static void main(String[] args) {
        int[][] matrix = {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };
        dfs547 obj = new dfs547();
        int circleNum = obj.findCircleNum(matrix);
        System.out.println(circleNum);
    }
}
