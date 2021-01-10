import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class window438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> rst = new ArrayList<>();
        if(p == null || s == null ) return rst;
        //init
        int[] ori = new int[26];
        for(int i = 0;i<p.length();i++){
            ori[p.charAt(i)-'a'] ++;
        }
        int[] temp = new int[26];

        int left = 0;
        int right = p.length();
        while(right<=s.length()) {
            String sub = s.substring(left,right);
            for(int i =0 ;i<sub.length();i++){
                temp[sub.charAt(i)-'a'] ++;
            }
            if(Arrays.equals(temp,ori)) {
                rst.add(left);
            }
            left++;
            right++;
            temp = new int[26];
        }

        return rst;
    }

    public static void main(String[] args) {
        window438 obj = new window438();
        List<Integer> anagrams = obj.findAnagrams("abab", "ab");
        System.out.println(anagrams.toString());
    }

}
