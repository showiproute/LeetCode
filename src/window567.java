import java.util.HashMap;
import java.util.Map;

public class window567 {

    HashMap<Character,Integer> ori = new HashMap<>();

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0) return true;
        if (s2 == null || s2.length() == 0) return false;

        //init
        for(int i = 0;i<s1.length();i++){
            ori.put(s1.charAt(i),ori.getOrDefault(s1.charAt(i),0)+1);
        }

        int left = 0;
        int right = s1.length();
        while(right <= s2.length()) {
            String temp = s2.substring(left, right);
            if(helper(temp)) {
                return true;
            }
            left++;
            right++;
        }

        return false;
    }

    public boolean helper(String temp) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        //init
        for(int i = 0;i<temp.length();i++){
            hashMap.put(temp.charAt(i),hashMap.getOrDefault(temp.charAt(i),0)+1);
        }

        for(Map.Entry<Character,Integer> keyValue : ori.entrySet()) {
            if(hashMap.getOrDefault(keyValue.getKey(),0) < keyValue.getValue()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        window567 obj = new window567();
        boolean b = obj.checkInclusion("ab", "eidboaoo");
        System.out.println(b);
    }

}
