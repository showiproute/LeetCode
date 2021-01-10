import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class offer13 {

    public int movingCount(int m, int n, int k) {
        if(k == 0) return 1;
        return bfs(m, n, k);
    }

    public int bfs(int m,int n,int k) {
        int counts = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        visited[0][0] = true;
        int[] dx = {0,1};
        int[] dy = {1,0};

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for(int i = 0;i<2;i++){
                int tx = dx[i]+x;
                int ty = dy[i]+y;
                if(tx< 0 || tx>= m || ty<0 || ty>=n || visited[tx][ty] || calculate(tx)+calculate(ty) > k) {
                    continue;
                }
                visited[tx][ty] = true;
                queue.offer(new int[]{tx,ty});
            }
            counts++;
        }

        return counts;
    }

    public int calculate(int x) {
        int sum = 0;
        while(x!=0) {
            sum+=x%10;
            x=x/10;
        }

        return sum;
    }

    public static void main(String[] args) {
        offer13 obj = new offer13();
        int i = obj.movingCount(16, 8, 4);
        System.out.println(i);

    }

}
