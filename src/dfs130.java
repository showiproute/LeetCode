import java.util.Arrays;
public class dfs130 {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                if(i==0 || j==0 || i==board.length-1 || j == board[0].length-1) {
                    if(board[i][j] == 'O'){
                        dfs(board,i,j);
                    }
                }
            }
        }


        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] board,int i,int j) {
        if(i<0 || i>= board.length || j<0 || j>=board[0].length || board[i][j] == 'X' || board[i][j] == '#'){
            return;
        }
        board[i][j] = '#';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }


    public static void main(String[] args) {
        char[][] arr = {
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}
        };
        dfs130 obj = new dfs130();
        obj.solve(arr);
        for(int i =0;i<arr.length;i++){
            System.out.println(Arrays.toString(arr[i]));
        }

    }



}
