import java.util.Arrays;

public class ms91 {

    public int numDecodings(String s) {
        if(s == null || s.length() ==0 ){
            return 0;
        }
        if(s.charAt(0) == '0') {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        dp[1] =1;
        if(s.charAt(0) == '1' && s.charAt(1) !='0') dp[1]=2;
        if(s.charAt(0) == '2'){
            if(s.charAt(1) >='1' && s.charAt(1) <='6') {
                dp[1]=2;
            }else{
                dp[1] =1;
            }
        }
        if(s.charAt(0)>'2' && s.charAt(1) =='0') return 0;

        for(int i =2;i<s.length();i++) {
            if(s.charAt(i) =='0') {
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2'){
                    dp[i] = dp[i-2];
                }else{
                    return 0;
                }
            }else if(s.charAt(i-1) == '1') {
                dp[i] = dp[i-1] + dp[i-2];
            }else if(s.charAt(i-1) == '2') {
                if(s.charAt(i) >= '1' && s.charAt(i) <='6'){
                    dp[i] = dp[i-1]+dp[i-2];
                }else{
                    dp[i] = dp[i-1];
                }
            }else{
                dp[i] = dp[i-1];
            }
        }
        System.out.println(Arrays.toString(dp));

        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        ms91 obj = new ms91();
        int i = obj.numDecodings("301");
        System.out.println(i);
    }
}
