import java.util.Arrays;

public class xor1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        if(queries == null || queries.length == 0 || queries[0].length == 0 || arr == null) return new int[]{};
        int[] rst = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            int val = 0;
            for(int j = left;j<=right;j++){
                val ^= arr[j];
            }
            rst[i] = val;
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,8};
        int[][] queries = {
                {0,1},
                {1,2},
                {0,3},
                {3,3}
        };
        xor1310 obj = new xor1310();
        int[] ints = obj.xorQueries(arr, queries);
        System.out.println(Arrays.toString(ints));
    }


}
