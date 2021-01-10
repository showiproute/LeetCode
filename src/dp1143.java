import java.util.Arrays;

public class dp1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text1.length() == 0 || text2 == null || text2.length() ==0) {
            return 0;
        }
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        //init
        for(int i = 0;i<text2.length();i++){
            dp[0][i] = 0;
        }
        for(int i = 0;i<text1.length();i++){
            dp[i][0] = 0;
        }
        text1 = "$"+text1;
        text2 = "$"+text2;

        for(int i = 1;i<text1.length();i++){
            for(int j =1;j<text2.length();j++){
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
//        for(int i = 0;i<dp.length;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        return dp[text1.length()-1][text2.length()-1];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        dp1143 obj = new dp1143();
        int i = obj.longestCommonSubsequence(text1, text2);
        System.out.println(i);
    }
}
