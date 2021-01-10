import java.util.Arrays;

public class dp718 {

//    public int findLength(int[] A, int[] B) {
//        if(A == null || B == null) return 0;
//
//        //暴力破解 O(n^3)
//        int maxValue = Integer.MIN_VALUE;
//        for(int i = 0;i<A.length;i++){
//            for(int j = 0;j<B.length;j++){
//                int x = i;
//                int y = j;
//                int counts= 0 ;
//                while(x<A.length && y < B.length && A[x] == B[y]) {
//                    x++;
//                    y++;
//                    counts++;
//                }
//                maxValue = Math.max(maxValue,counts);
//            }
//        }
//
//        return maxValue;
//    }

    public int findLength(int[] A, int[] B) {
        if(A == null || B == null) return 0;
        int lengthA = A.length;
        int lengthB = B.length;
        int maxValue = Integer.MIN_VALUE;
        int[][] dp = new int[lengthA+1][lengthB+1];
        dp[lengthA][lengthB] = 0;
        for(int i= lengthA-1;i>=0;i--){
            for(int j = lengthB-1;j>=0;j--){
                if(A[i] == B[j]) {
                    dp[i][j] = dp[i+1][j+1]+1;
                    maxValue = Math.max(maxValue,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        dp718 obj = new dp718();
        /*
        A: [1,2,3,2,1]
B: [3,2,1,4,7]
         */
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        int length = obj.findLength(A, B);
        System.out.println(length);
    }


}
