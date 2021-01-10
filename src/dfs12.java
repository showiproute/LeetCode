import java.util.Arrays;

public class dfs12 {

    public String word;
    public char[][] board;
    public boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        if(word == null || word.length() == 0) return true;
        visited = new boolean[board.length][board[0].length];
        this.word =word;
        this.board = board;

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(dfs(i,j,0)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int i,int j,int index) {
        if(i < 0 || i > board.length || j<0 || j>board.length || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if(index == word.length()-1) {
            return true;
        }
        boolean found = dfs(i - 1, j, index + 1) || dfs(i, j - 1, index + 1) ||
                dfs(i + 1, j, index + 1) || dfs(i, j + 1, index + 1);
        visited[i][j] = false;
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        dfs12 obj = new dfs12();
        boolean abcced = obj.exist(board, "ABCCEESE");
        System.out.println(abcced);
    }


}
