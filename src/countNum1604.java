public class countNum1604 {

    public String tictactoe(String[] board) {
        int N = board.length;
        int rows = 0,cols = 0,dig1 = 0,dig2 = 0;
        boolean hasBlank = false;
        for(int i = 0;i<N;i++){
            rows = 0;
            cols = 0;
            dig1+=board[i].charAt(i);
            dig2+=board[i].charAt(N-i-1);
            for(int j = 0;j<N;j++){
                rows+=board[i].charAt(j);
                cols+=board[j].charAt(i);
                if(board[i].charAt(j) == ' ') hasBlank = true;
            }
            if(rows == 'X' * N || cols == 'X' * N) return "X";
            if(rows == 'O' * N || cols == 'O' * N) return "O";
        }
        if(dig1 == 'X' * N || dig2 == 'X' * N) return "X";
        if(dig1 == 'O' * N || dig2 == 'O' * N) return "O";
        if(hasBlank) return "Pending";
        return "Draw";
    }

}
