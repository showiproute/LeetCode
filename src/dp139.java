import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class dp139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s  == null || s.length() == 0) return true;
        HashSet<String> hashSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        //base
        dp[0] = true;
        for(int i = 1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && hashSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

//        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode22";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        dp139 obj = new dp139();
        boolean b = obj.wordBreak(s, wordDict);
        System.out.println(b);
    }
}
