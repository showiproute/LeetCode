import java.util.HashSet;

public class array840 {

    /*

输出: 1
解释:
下面的子矩阵是一个 3 x 3 的幻方：
438
951
276

而这一个不是：
384
519

     */
    public int numMagicSquaresInside(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        if(rows < 3 || cols < 3) return 0;
        int cnts = 0;
        for(int i = 0;i<rows-2;i++){
            for(int j = 0;j<cols-2;j++){
//                System.out.println("i"+i+"j"+j);
                HashSet<Integer> hashSet = new HashSet<>();
                if(helper(grid,i,j,hashSet)){
                    cnts++;
                }
            }
        }

        return cnts;
    }

    public boolean helper(int[][] grid,int x,int y,HashSet<Integer> hashSet) {
        for(int i = x;i<x+3;i++){
            for(int j = y;j<y+3;j++){
                if(grid[i][j] <=0 || grid[i][j]>=10) return false;
                hashSet.add(grid[i][j]);
            }
        }
        if(hashSet.size() != 9) return false;

        int val = grid[x][y]+grid[x][y+1]+grid[x][y+2];
//        System.out.println("val"+val);
        //rows 0 1 2
        if(grid[x+1][y]+grid[x+1][y+1]+grid[x+1][y+2] != val) return false;
        if(grid[x+2][y]+grid[x+2][y+1]+grid[x+2][y+2] != val) return false;
        //cols 0 1 2
        if(grid[x][y]+grid[x+1][y]+grid[x+2][y] != val) return false;
        if(grid[x][y+1]+grid[x+1][y+1]+grid[x+2][y+1] != val) return false;
        if(grid[x][y+2]+grid[x+1][y+2]+grid[x+2][y+2] != val) return false;
        //
        if(grid[x][y]+grid[x+1][y+1]+grid[x+2][y+2] != val) return false;
        if(grid[x][y+2]+grid[x+1][y+1]+grid[x+2][y] != val) return false;

        return true;
    }

    //    输入: [[4,3,8,4],
    //      [9,5,1,9],
    //      [2,7,6,2]]
    public static void main(String[] args) {
        array840 obj = new array840();
        int[][] grid=  {
                {4,3,8,4},
                {9,5,1,9},
                {2,7,6,2}
        };
        int i = obj.numMagicSquaresInside(grid);
        System.out.println(i);
    }

}
