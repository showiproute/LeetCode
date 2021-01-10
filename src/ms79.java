public class ms79 {

    int row ;
    int col;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                if(dfs(i,j,0,board,word)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int i ,int j,int k,char[][] board,String word){
        if(i<0 || i>= row || j<0 || j>=col || visited[i][j]) return false;
        if(k == word.length()-1) return word.charAt(k) == board[i][j];
        if(board[i][j] != word.charAt(k)) return false;
        visited[i][j] = true;
        boolean found = dfs(i,j-1,k+1,board,word) || dfs(i,j+1,k+1,board,word)
                ||dfs(i-1,j,k+1,board,word) || dfs(i+1,j,k+1,board,word);
        visited[i][j] = false;

        return found;
    }



    public static void main(String[] args) {
//        board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        ms79 obj = new ms79();
        boolean abcced = obj.exist(board, "ABCCEDASFC");
        System.out.println(abcced);

    }
}
