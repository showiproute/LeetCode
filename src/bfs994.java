import java.util.LinkedList;
import java.util.Queue;

public class bfs994 {

    public class point {
        int x;
        int y;
        public point(int x,int y) {
            this.x= x;
            this.y =y;
        }
    }

    public int[][] grid;
    Queue<point> queue = new LinkedList<>();
    public int sum = 0;
    public int rows = 0;
    public int cols = 0;

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length ==0 )return -1;
        if(grid.length == 1 && grid[0].length ==1 && grid[0][0] == 0) return 0;
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        int size = 0;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == 1) {
                    size++;
                }else if(grid[i][j] == 2) {
                    point p = new point(i, j);
                    queue.offer(p);
                }
            }
        }
        int counts = 0;
        while(!queue.isEmpty()) {
            int length = queue.size();
            for(int i = 0;i<length;i++){
                point p = queue.poll();
                //四个方向是否有newOrange
                hasNewOrange(p.x,p.y);
            }
            counts++;
        }

        if(size == sum) {
            return counts-1;
        }else{
            return -1;
        }
    }

    public void hasNewOrange(int i,int j) {
        //up
        if(i-1>=0 && grid[i-1][j] == 1) {
            point p = new point(i - 1, j);
            queue.offer(p);
            sum++;
            grid[i-1][j] = 2;
        }
        //down
        if(i+1<rows && grid[i+1][j] == 1) {
            point p = new point(i+1,j);
            queue.offer(p);
            sum++;
            grid[i+1][j] =2;
        }
        //left
        if(j-1>=0 && grid[i][j-1] == 1) {
            point p = new point(i,j-1);
            queue.offer(p);
            sum++;
            grid[i][j-1] = 2;
        }
        //right
        if(j+1<cols && grid[i][j+1] == 1) {
            point p = new point(i,j+1);
            queue.offer(p);
            sum++;
            grid[i][j+1]=2;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0},
        };
        bfs994 obj = new bfs994();
        int i = obj.orangesRotting(arr);
        System.out.println(i);
    }
}
