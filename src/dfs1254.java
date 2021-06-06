public class dfs1254 {

    public int closedIsland(int[][] grid) {
        int cnts = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                boolean[][] visited = new boolean[grid.length][grid[0].length];
                if (grid[i][j] == 0) {
                    if(dfs(grid,i,j,visited)) {
//                        System.out.println("i="+i+"j="+j);
                        cnts++;
                    }
                }
            }
        }
        //test
//        for(int i = 0;i<visited.length;i++){
//            System.out.println(Arrays.toString(visited[i]));
//        }

        return cnts;
    }

    public boolean dfs(int[][] grid,int x,int y,boolean[][] visited) {
        if(x < 0 || y < 0 || x>=grid.length || y>= grid[0].length) return false;
        if(grid[x][y] == 1 || visited[x][y]) return true;
        visited[x][y] = true;
        grid[x][y] = -1;
        return dfs(grid,x-1,y,visited) &&
                dfs(grid,x,y-1,visited) &&
                dfs(grid,x+1,y,visited) &&
                dfs(grid,x,y+1,visited);
    }
    /*
    [0,0,1,1,0,1,0,0,1,0],
    [1,1,X,1,1,0,1,1,1,0],
    [1,X,1,1,1,0,0,1,1,0],
    [0,1,1,0,0,0,0,1,X,1],
    [0,0,0,0,0,0,1,1,1,0],
    [0,1,0,1,0,1,0,1,1,1],
    [1,X,1,X,1,1,0,0,0,1],
    [1,1,1,1,1,1,0,0,0,0],
    [1,1,1,0,0,1,0,1,0,1],
    [1,1,1,0,1,1,0,1,1,0]]
     */

    public static void main(String[] args) {
//        int[][] grid = {
//                {0,0,1,1,0,1,0,0,1,0},
//                {1,1,0,1,1,0,1,1,1,0},
//                {1,0,1,1,1,0,0,1,1,0},
//                {0,1,1,0,0,0,0,1,0,1},
//                {0,0,0,0,0,0,1,1,1,0},
//                {0,1,0,1,0,1,0,1,1,1},
//                {1,0,1,0,1,1,0,0,0,1},
//                {1,1,1,1,1,1,0,0,0,0},
//                {1,1,1,0,0,1,0,1,0,1},
//                {1,1,1,0,1,1,0,1,1,0}
//        };
        int[][] grid = {
                {}
        };
        dfs1254 obj = new dfs1254();
        int i = obj.closedIsland(grid);
        System.out.println(i);
    }
}
