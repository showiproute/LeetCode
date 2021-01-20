public class graph1232 {

    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates == null || coordinates.length <=2) return true;
        for(int i = 1;i<coordinates.length-1;i++){
            int x1 = coordinates[i][0]-coordinates[i-1][0];
            int y1 = coordinates[i][1]-coordinates[i-1][1];
            int x2 = coordinates[i+1][0]-coordinates[i][0];
            int y2 = coordinates[i+1][1]-coordinates[i][1];
            if(x1*y2 != x2 * y1) return false;
        }


        return true;
    }

//    输入：coordinates =[[0,0],[0,1],[0,-1]]
    public static void main(String[] args) {
        graph1232 obj = new graph1232();
        int[][] arr = {
                {0,0},
                {0,1},
                {0,-1}
        };
        boolean b = obj.checkStraightLine(arr);
        System.out.println(b);
    }


}
