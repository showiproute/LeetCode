import java.util.ArrayList;
import java.util.List;

public class matrix54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList<>();
        if(matrix== null || matrix.length ==0) return rst;
        int row= matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        int[][] directions = {
                {0,1}, //right
                {1,0}, //down
                {0,-1}, //left
                {-1,0} //up
        };
        int i = 0,j=0;
        int dir = 0;
        for(int k = 0;k<row*col;k++){
            visited[i][j] = true;
            rst.add(matrix[i][j]);
            int nextRow = i+ directions[dir][0];
            int nextCol = j+ directions[dir][1];
            if(nextRow<0 || nextRow>=row || nextCol<0 || nextCol>=col || visited[nextRow][nextCol]) {
                dir = (dir+1)%4;
            }
            i +=directions[dir][0];
            j +=directions[dir][1];
        }

        return rst;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        matrix54 obj = new matrix54();
        List<Integer> integers = obj.spiralOrder(matrix);
        System.out.println(integers.toString());
    }
}
