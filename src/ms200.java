public class ms200 {

    int row ;
    int col;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int counts = 0;
        row = grid.length;
        col = grid[0].length;
        for(int i = 0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    counts++;
                    dfs(grid,i,j);
                }
            }
        }

        return counts;
    }

    public void dfs(char[][] grid,int i ,int j ){
        if(i<0 || i>=row || j<0 || j>=col || grid[i][j] == '0' || grid[i][j] == '2') {
            return;
        }

        grid[i][j] = '2';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        ms200 obj = new ms200();
        int i = obj.numIslands(grid);
        System.out.println(i);
    }

}