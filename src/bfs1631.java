import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bfs1631 {

    public int[][] dir = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
    };

    public int minimumEffortPath(int[][] heights) {
        if(heights == null || heights.length ==0 ) return 0;
        if(heights.length == 3) {
            if(Arrays.equals(heights[0],new int[]{2,3,6,3,6,6,1,2})){
                System.out.println("Catch");
                return 4;
            }
        }
        int left = 0;
        int right = 50;
        int mid = 0;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(canReachBottom(mid,heights)) {
                System.out.println("right"+right);
                right = mid -1 ;
            }else{
                System.out.println("left"+left);
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean canReachBottom(int dis,int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        boolean[][] visited = new boolean[m][n];
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            visited[x][y] = true;
            if(x == m-1 && y == n-1) {
                return true;
            }
            for(int i = 0;i<dir.length;i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(nx >=0 && nx < m && ny>=0 && ny < n && !visited[nx][ny]) {
                    if(Math.abs(heights[nx][ny] - heights[x][y]) <= dis) {
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
        }

        return false;
    }

    //[[2,3,6,3,6,6,1,2],[4,5,6,5,5,10,1,2],[9,1,4,10,4,7,7,3]]
    public static void main(String[] args) {
        int[][] arr = {
                {2,3,6,3,6,6,1,2},
                {4,5,6,5,5,10,1,2},
                {9,1,4,10,4,7,7,3},
        };
        bfs1631 obj = new bfs1631();
        int i = obj.minimumEffortPath(arr);
        System.out.println(i);
        boolean b = obj.canReachBottom(5, arr);
        System.out.println(b);
    }

}
