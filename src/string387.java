import java.util.HashMap;
import java.util.LinkedHashMap;

public class string387 {

    public int firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> hashMap = new LinkedHashMap<>();
        for(int i= 0 ;i<s.length();i++){
            hashMap.put(s.charAt(i),hashMap.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i= 0;i<s.length();i++){
            if(hashMap.containsKey(s.charAt(i)) && hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        string387 obj = new string387();
        int i = obj.firstUniqChar(s);
        System.out.println(i);
    }
}
