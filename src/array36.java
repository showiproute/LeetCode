import java.util.HashSet;

public class array36 {

    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length ==0 ) return false;
        //3X3
        for(int i = 0;i<board.length;i+=3){
            for(int j = 0 ;j<board[0].length;j+=3){
                HashSet<Character> hashSet = new HashSet<>();
                for(int m = i;m<i+3;m++) {
                    for(int n = j;n<j+3;n++){
                        if(board[m][n] != '.'){
                            if(hashSet.contains(board[m][n]) || !lineOrRowsFind(m,n,board)) {
                                return false;
                            }else{
                                hashSet.add(board[m][n]);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean lineOrRowsFind(int x,int y,char[][] board) {
        char val = board[x][y];
        for(int i =0;i<board.length;i++){
            if(i == x) continue;
            if(board[i][y] == val) {
                System.out.println("x"+x+"y"+y);
                return false;
            }
        }
        for(int j = 0;j<board[0].length;j++){
            if(j == y) continue;
            if(board[x][j] == val) {
                System.out.println("x"+x+"y"+y);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','5','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','.','9'},
        };
        array36 obj = new array36();
        boolean validSudoku = obj.isValidSudoku(board);
        System.out.println(validSudoku);

    }
}
