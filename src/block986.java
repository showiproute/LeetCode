import java.util.ArrayList;
import java.util.Arrays;

public class block986 {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A == null || A.length ==0 || B == null || B.length == 0) return new int[][]{};

        ArrayList<int[]> list = new ArrayList<>();

        int i = 0;
        int j = 0;
        while(i < A.length && j < B.length) {
            int a1 = A[i][0];
            int a2 = A[i][1];
            int b1 = B[j][0];
            int b2 = B[j][1];
            if(!(a1 > b2 || b1 > a2)) {
                int[] temp = new int[2];
                temp[0] = Math.max(a1,b1);
                temp[1] = Math.min(a2,b2);
                list.add(temp);
            }
            if(a2>=b2) {
                j++;
            }else{
                i++;
            }
        }

        int[][] rst = new int[list.size()][2];
        for(int k = 0;k<list.size();k++){
            rst[k] = list.get(k);
        }

        return rst;
    }

    public static void main(String[] args) {
            /*
            输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
             */
        int[][] A = {
                {0,2},
                {5,10},
                {13,23},
                {24,25}
        };
        int[][] B = {
                {1,5},
                {8,12},
                {15,24},
                {25,26}
        };
        block986 obj  = new block986();
        int[][] ints = obj.intervalIntersection(A, B);
        for(int i = 0;i<ints.length;i++){
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}
