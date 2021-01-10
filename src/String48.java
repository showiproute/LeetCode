import java.util.HashSet;

public class String48 {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() ==0) return 0;
        int maxValue = 0;
        HashSet<Character> hashSet = new HashSet<>();
        for(int i = 0;i<s.length();i++){
            hashSet = new HashSet<>();
            hashSet.add(s.charAt(i));
            for(int j =i+1;j<s.length();j++){
                if(hashSet.contains(s.charAt(j))){
                    break;
                }else{
                    hashSet.add(s.charAt(j));
                    maxValue = Math.max(maxValue,hashSet.size());
                }
            }
        }

        return maxValue;
    }




}
