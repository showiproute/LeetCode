import java.util.Arrays;

public class offer29 {

    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0) return new int[]{};
        int rows= matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited  = new boolean[rows][cols];
        int[] result = new int[rows*cols];
        int[][] directions = {
                {0,1},
                {1,0},
                {0,-1},
                {-1,0}
        };

        int i =0,j=0;
        int dir = 0;
        for(int k =0;k<rows*cols;k++) {
            visited[i][j] = true;
            result[k] = matrix[i][j];
            int nextRow = i+directions[dir][0];
            int nextCol = j+directions[dir][1];
            if(nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                dir = (dir+1)%4;
            }
            i+=directions[dir][0];
            j+=directions[dir][1];
        }

        return result;
    }

    public static void main(String[] args) {
        offer29 obj = new offer29();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
//        int[] ints = obj.spiralOrder(matrix);
//        System.out.println(Arrays.toString(ints));
        obj.spiralOrder(null);
    }
}
