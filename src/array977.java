import java.util.Arrays;

public class array977 {

    public int[] sortedSquares(int[] A) {
        if(A == null || A.length ==0) return new int[]{};
        int[] rst = new int[A.length];
        for(int i = 0;i<A.length;i++){
            rst[i] = (int) Math.pow(A[i],2);
        }
        Arrays.sort(rst);

        return rst;
    }

}
