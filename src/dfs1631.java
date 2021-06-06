public class dfs1631 {

    int[][] dirs = {
            {0,1},
            {0,-1},
            {-1,0},
            {1,0}
    };

    public int minimumEffortPath(int[][] heights) {
        if(heights == null || heights.length == 0) return 0;
        int left = 0;
        int right= 1000000;
        while (left <= right) {
            int mid = (left+right)/2;
            if(!dfs(heights,new boolean[heights.length][heights[0].length],mid,0,0)){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return left;
    }

    public boolean dfs(int[][] heights,boolean[][] visited,int max,int x,int y) {
        if(x == heights.length-1 && y == heights[0].length-1) return true;
        //test
//        System.out.println(x+":"+y);
        visited[x][y] = true;
        for(int i = 0;i<dirs.length;i++){
            int nx = x+dirs[i][0];
            int ny = y+dirs[i][1];
            if(nx >=0 && nx < heights.length && ny >=0 && ny<heights[0].length
            && !visited[nx][ny] && Math.abs(heights[nx][ny] - heights[x][y]) <=max) {
                boolean dfs = dfs(heights, visited, max, nx, ny);
                if(dfs) {
                    return true;
                }
            }
        }

        return false;
    }
//[[1,1000000]]
    public static void main(String[] args) {
        int[][] arr = {
                {1,1000000}
        };
        dfs1631 obj = new dfs1631();
        int i = obj.minimumEffortPath(arr);
        System.out.println(i);
    }

}
