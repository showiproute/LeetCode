import java.awt.*;
import java.util.HashMap;

public class hash205 {

    //示例 1:
    //
    //输入：s = "egg", t = "add"
    //输出：true
    //示例 2：
    //
    //输入：s = "foo", t = "bar"
    //输出：false
    //示例 3：
    //
    //输入：s = "paper", t = "title"
    //输出：true

    //"badc"
    //"baba"
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> hashMapS = new HashMap<>();
        HashMap<Character,Character> hashMapT = new HashMap<>();
        for(int i= 0 ;i<s.length();i++){
            char S = s.charAt(i);
            char T = t.charAt(i);
            if(hashMapS.containsKey(S) && hashMapS.get(S) != T ||
            hashMapT.containsKey(T) && hashMapT.get(T) != S) {
                return false;
            }
            hashMapS.put(S,T);
            hashMapT.put(T,S);
        }

        return true;
    }

    public static void main(String[] args) {
        hash205 obj = new hash205();
        boolean isomorphic = obj.isIsomorphic("egg", "add");
        System.out.println(isomorphic);
    }
}
