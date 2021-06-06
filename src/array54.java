import java.util.ArrayList;
import java.util.List;

public class array54 {

    //输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
    //输出：[1,2,3,6,9,8,7,4,5]
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {
                {0,1}, //right
                {1,0}, //down
                {0,-1}, //left
                {-1,0} // up
        };
        int i =0,j=0;
        int dir = 0;
        for(int k = 0;k<rows*cols;k++){
//            System.out.println("i"+i+"j"+j);
            visited[i][j] = true;
            rst.add(matrix[i][j]);
            int nextRows = i+directions[dir][0];
            int nextCols = j+directions[dir][1];
//            System.out.println("nextRows"+nextRows+"nextCols"+nextCols);
            if(nextRows < 0 || nextRows >= rows || nextCols < 0 || nextCols >=cols || visited[nextRows][nextCols]) {
                dir = (dir+1) % 4;
            }
            i += directions[dir][0];
            j += directions[dir][1];
        }

        return rst;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        array54 obj = new array54();
        List<Integer> integers = obj.spiralOrder(matrix);
        System.out.println(integers.toString());
    }

}
