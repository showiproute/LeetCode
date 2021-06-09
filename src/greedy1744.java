import java.util.Arrays;

public class greedy1744 {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] rst = new boolean[queries.length];
        long[] prefixSum = new long[candiesCount.length];
        prefixSum[0] = candiesCount[0];
        for(int i = 1;i<prefixSum.length;i++){
            prefixSum[i] = prefixSum[i-1]+candiesCount[i];
        }
        for(int i = 0;i<queries.length;i++){
            int type = queries[i][0];
            int day = queries[i][1];
            int cap = queries[i][2];
            long x1 = day+1;
            long y1 = (long)(day+1) * cap;
            long x2 = type == 0 ? 1 : prefixSum[type-1]+1;
            long y2 = prefixSum[type];
            rst[i] = !(x1>y2 || y1<x2);
        }

        return rst;
    }

    public static void main(String[] args) {
        greedy1744 obj = new greedy1744();
        int[] candiesCount = {5,2,6,4,1};
        int[][] query = {
                {3,1,2},
                {4,10,3},
                {3,10,100},
                {4,100,30},
                {1,3,1}
        };
        boolean[] booleans = obj.canEat(candiesCount, query);
        System.out.println(Arrays.toString(booleans));
    }

}
