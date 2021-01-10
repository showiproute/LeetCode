import java.util.HashSet;

public class window3 {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() ==0 ) return 0;
        int left = 0;
        int right = 0;
        int maxValue = Integer.MIN_VALUE;
        HashSet<Character> hashSet = new HashSet<>();

        while(right < s.length() ) {
            if(!hashSet.contains(s.charAt(right))) {
                hashSet.add(s.charAt(right));
                maxValue = Math.max(maxValue,hashSet.size());
                right++;
            }else{
                hashSet.remove(s.charAt(left));
                left++;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        window3 obj = new window3();
        int abcabcbb = obj.lengthOfLongestSubstring("abcabcbb");
        System.out.println(abcabcbb);
    }

}

