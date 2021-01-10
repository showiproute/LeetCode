import java.util.Arrays;

public class dp5 {

//    public String longestPalindrome(String s) {
//        if(s == null || s.length() == 0) return "";
//        if(s.length() == 1) return s;
//        int length = s.length();
//        boolean[][] dp = new boolean[length][length];
//        //base
//        for(int i = 0;i<length;i++){
//            dp[i][i] = true;
//        }
//        int ans = 1;
//        String rst = s.charAt(0)+"";
//        for(int i = s.length()-1;i>=0;i--){
//            for(int j = s.length()-1;j>=i;j--){
//                if(i == j) continue;
//                if(s.charAt(i) == s.charAt(j)) {
//                    if(j-i<2) {
//                        dp[i][j] = true;
//                    }else{
//                        dp[i][j] = dp[i+1][j-1];
//                    }
//                    if(dp[i][j]) {
//                        if(j-i+1 > ans){
//                            ans = j-i+1;
//                            rst = s.substring(i,j+1);
//                        }
//                    }
//                }
//            }
//        }
//
////        System.out.println(ans);
////
////        for(int i =0 ;i<dp.length;i++){
////            System.out.println(Arrays.toString(dp[i]));
////        }
//
//        return rst;
//    }

    public String longestPalindrome(String s) {
        String rst = s.charAt(0)+"";
        for(int i = 0;i<s.length();i++){
            String first = isPalindrome(s, i, i);
            String second = isPalindrome(s, i, i + 1);
            rst = rst.length() < first.length() ? first : rst;
            rst = rst.length() < second.length() ? second : rst;
        }

        return rst;
    }

    public String isPalindrome(String s,int left,int right) {
        while(left >=0 && right < s.length()) {
            if(s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }else{
                break;
            }
        }

        return s.substring(left+1,right);
    }

    public static void main(String[] args) {
        dp5 obj = new dp5();
        String babad = obj.longestPalindrome("cbbd");
        System.out.println(babad);
    }
}
