import java.util.Arrays;

public class matrix59 {

    public int[][] generateMatrix(int n) {
        if(n <=0 ) return null;
        int row = n,col = n;
        int[][] array = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        int[][] directions = {
                {0,1},//right
                {1,0}, //down
                {0,-1}, //left
                {-1,0} //up
        };
        int x=0,y=0,dir=0;

        for(int i =1;i<=n*n;i++){
            visited[x][y] = true;
            array[x][y] = i;
            int next_x = x+directions[dir][0];
            int next_y = y+directions[dir][1];
            if(next_x <0 || next_x >=row || next_y <0 || next_y >=col || visited[next_x][next_y]){
                dir = (dir+1)%4;
            }
            x += directions[dir][0];
            y +=directions[dir][1];
        }

        return array;
    }

    public static void main(String[] args) {
        matrix59 obj = new matrix59();
        int[][] ints = obj.generateMatrix(3);
        for(int i = 0;i<ints.length;i++){
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}
