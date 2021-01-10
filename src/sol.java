public class sol {

    int[][] temp;
    public void init(int[][] matrix) {
        temp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j= 0;j<matrix[0].length;j++){
                //累加范围
                int sum = 0;
                for(int x =0;x<=i;x++){
                    for(int y =0;y<=j;y++){
                        sum+=matrix[x][y];
                    }
                }
                temp[i][j] = sum;
            }
        }
    }

    public int getRangeSum(int a1,int b1,int a2,int b2) {
        int rightDown = temp[a2][b2];
        int leftUp = 0;
        int rightUp = 0;
        int leftDown = 0;
        if(a1>0 && b1 >0) {
            leftUp = temp[a1-1][b1-1];
        }
        if(a1-1>=0) {
            rightUp = temp[a1-1][b2];
        }
        if(b1-1>=0) {
            leftDown = temp[a2][b1-1];
        }

        return rightDown - rightUp - leftDown + leftUp;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        sol obj = new sol();
        obj.init(matrix);
        int rangeSum = obj.getRangeSum(1,0, 2, 2);
        System.out.println(rangeSum);
    }

}
