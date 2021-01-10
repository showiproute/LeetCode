public class dfs329 {

    public int[][] dirs = {
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
    };
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length ==0) return 0;

        int[][] memo = new int[matrix.length][matrix[0].length];
        int maxLength = 0;
        for(int i= 0 ;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                maxLength = Math.max(maxLength,dfs(matrix,memo,i,j));
            }
        }

        return maxLength;
    }

    public int dfs(int[][] matrix,int[][] memo,int i,int j) {
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length) return 0;
        if(memo[i][j] !=0) {
            return memo[i][j];
        }
        memo[i][j]++;
        for(int k=0;k<dirs.length;k++){
            int x = i+dirs[k][0];
            int y = j+dirs[k][1];
            if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length && matrix[x][y] > matrix[i][j]){
                memo[i][j] = Math.max(1+dfs(matrix,memo,x,y),memo[i][j]);
            }
        }

        return memo[i][j];
    }

    public static void main(String[] args) {
        dfs329 obj = new dfs329();
//[[3,4,5],[3,2,6],[2,2,1]]
        int[][] matrix = {
                {3,4,5},
                {3,2,6},
                {2,2,1}
        };
        int i = obj.longestIncreasingPath(matrix);
        System.out.println(i);


    }
}
