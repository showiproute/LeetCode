import java.util.Arrays;

public class array289 {


    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        int[][] temp = new int[board.length][board[0].length];
        for(int i= 0;i<board.length;i++){
            for(int j= 0;j<board[0].length;j++){
                helper(board,i,j,temp);
            }
        }
        for(int i= 0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                board[i][j] = temp[i][j];
            }
        }
    }

    public void helper(int[][] board,int x,int y,int[][] temp) {
        int cnts = 0;
        if(x-1 >=0 && y-1 >=0 && board[x-1][y-1] == 1) {
            cnts++;
        }
        if(x-1 >=0 && board[x-1][y] == 1) {
            cnts++;
        }
        if(x-1 >= 0 && y+1 < board[0].length && board[x-1][y+1] == 1) {
            cnts++;
        }
        if(y-1 >=0 && board[x][y-1] == 1) {
            cnts++;
        }
        if(y+1 < board[0].length && board[x][y+1] == 1) {
            cnts++;
        }
        if(x+1 < board.length && y-1 >=0 && board[x+1][y-1] == 1) {
            cnts++;
        }
        if(x+1 < board.length && board[x+1][y] == 1) {
            cnts++;
        }
        if(x+1 < board.length && y+1 < board[0].length && board[x+1][y+1] == 1){
            cnts++;
        }
        //如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
        //如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
        //如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
        //如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
//        if(cnts < 2) temp[x][y] = 0;
        if(cnts >=2 && cnts <=3 && board[x][y] == 1) temp[x][y] = 1;
//        if(cnts > 3 && board[x][y] == 1) temp[x][y] =0;
        if(cnts == 3 && board[x][y] == 0) temp[x][y] = 1;
    }

    //输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
    //输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
    //
    public static void main(String[] args) {
        int[][] board = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        array289 obj = new array289();
        obj.gameOfLife(board);
        //test
        for(int i= 0;i<board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
