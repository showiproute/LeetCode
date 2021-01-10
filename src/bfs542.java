import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class bfs542 {

/*
输入：
[[0,0,0],
 [0,1,0],
 [1,1,1]]

输出：
[[0,0,0],
 [0,1,0],
 [1,2,1]]
 */

    //暴力bfs
//    public int[][] updateMatrix(int[][] matrix) {
//        if (matrix == null || matrix.length == 0) return new int[][]{};
//        int[][] rst = new int[matrix.length][matrix[0].length];
//        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
//        Queue<int[]> queue = new LinkedList<>();
//        for(int i = 0;i<matrix.length;i++){
//            for(int j = 0;j<matrix[0].length;j++){
//                if(matrix[i][j] != 0) {
//                    visited = new boolean[matrix.length][matrix[0].length];
//                    queue = new LinkedList<>();
//                    queue.offer(new int[]{i,j});
//                    int depth = 0;
//                    boolean needContinue = true;
//                    while(!queue.isEmpty() && needContinue) {
//                        int size = queue.size();
//                        depth++;
//                        for(int k = 0;k<size;k++){
//                            int[] poll = queue.poll();
//                            int x = poll[0];
//                            int y = poll[1];
//                            visited[x][y] = true;
//                            if(hasZero(x,y,matrix)) {
//                                rst[i][j] = depth;
//                                needContinue = false;
//                                break;
//                            }else{
//                                if(x-1>=0 && !visited[x-1][y]) {
//                                    queue.offer(new int[]{x-1,y});
//                                }
//                                if(x+1<matrix.length && !visited[x+1][y]) {
//                                    queue.offer(new int[]{x+1,y});
//                                }
//                                if(y-1>=0 && !visited[x][y-1]){
//                                    queue.offer(new int[]{x,y-1});
//                                }
//                                if(y+1<matrix[0].length && !visited[x][y+1]) {
//                                    queue.offer(new int[]{x,y+1});
//                                }
//                            }
//                        }
//
//                    }
//                }
//            }
//        }
//
//
//        return rst;
//    }
//
//    public boolean hasZero(int i ,int j,int[][] matrix) {
//        if(i-1>=0 && matrix[i-1][j] == 0) return true;
//        if(i+1<matrix.length && matrix[i+1][j] == 0) return true;
//        if(j-1>=0 && matrix[i][j-1] == 0) return true;
//        if(j+1<matrix[0].length && matrix[i][j+1] == 0) return true;
//        return false;
//    }


    /*
输入：
[[0,1,0,1,1],[1,1,0,0,1],[0,0,0,1,0],[1,0,1,1,1],[1,0,0,0,1]]
输出：
[[0,0,0],
 [0,1,0],
 [1,2,1]]
     */

    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length == 0) return new int[][]{};
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int[][] rst = new int[matrix.length][matrix[0].length];
        int[][] dir = {
                {0,1},
                {1,0},
                {-1,0},
                {0,-1}
        };
        //put all the zeros into queue
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] ==0) {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for(int i = 0;i<dir.length;i++){
                int nx = x+dir[i][0];
                int ny = y+dir[i][1];
                if(nx >=0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length && !visited[nx][ny]){
                    queue.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    rst[nx][ny] = rst[x][y]+1;
                }
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        bfs542 obj = new bfs542();
        int[][] matrix = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        int[][] ints = obj.updateMatrix(matrix);
        for(int i = 0;i<ints.length;i++){
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}
