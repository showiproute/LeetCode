import java.util.Arrays;

public class dp516 {

    public int longestPalindromeSubseq(String s) {
        s = "#"+s;
        int[][] dp = new int[s.length()+1][s.length()+1];
        //base case
        for(int i = 1;i<s.length();i++){
            dp[i][i] = 1;
        }
        for(int j = 1; j < s.length();j++){
            for(int i = j-1;i>=0;i--){
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }

        //test
        for(int i =0;i<dp.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[1][s.length()-1];
    }


    //状态压缩到o(n)



    public static void main(String[] args) {
        dp516 obj = new dp516();
        int bbbab = obj.longestPalindromeSubseq("bbbab");
        System.out.println(bbbab);
    }



}
