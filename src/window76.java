import java.util.HashMap;
import java.util.Map;

public class window76 {

    public HashMap<Character,Integer> tMap = new HashMap<>();
    public HashMap<Character,Integer> temp = new HashMap<>();

    public String minWindow(String s, String t) {
        //init
        for(int i = 0;i<t.length();i++){
            if(tMap.containsKey(t.charAt(i))) {
                tMap.put(t.charAt(i),tMap.get(t.charAt(i))+1);
            }else{
                tMap.put(t.charAt(i),1);
            }
        }

        int left = 0;
        int right = 0;
        int minStrLen = s.length()+1;
        String rst = "";

        while(right < s.length()) {
            if(tMap.containsKey(s.charAt(right))) {
                temp.put(s.charAt(right),temp.getOrDefault(s.charAt(right),0)+1);
            }
            while(left <= right && helper()) {
                if(right-left+1 < minStrLen) {
                    minStrLen = right-left+1;
                    rst = s.substring(left,left+minStrLen);
                }
                temp.put(s.charAt(left),temp.getOrDefault(s.charAt(left),0)-1);
                left++;
            }
            right++;
        }

        return rst;
    }

    public boolean helper(){
        for(Map.Entry<Character,Integer> keyValue : tMap.entrySet()) {
            if(temp.getOrDefault(keyValue.getKey(),0) < keyValue.getValue()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        window76 obj = new window76();
        String s = obj.minWindow("A", "A");
        System.out.println(s);
    }

}
