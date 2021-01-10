import java.util.HashSet;

public class string290{

    public boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");
        if(pattern.length() != array.length ) return  false;
        HashSet<String> hashSet = new HashSet<>();
        boolean[] visited = new boolean[pattern.length()];
        for(int i=0;i<pattern.length();i++){
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            char val = pattern.charAt(i);
            String sVal = array[i];
            for(int j = i+1;j<s.length();j++){
                if(j<array.length && pattern.charAt(j) == val) {
                    if(!array[j].equals(sVal)) {
                        return false;
                    }
                    visited[j] = true;
                }
            }
            if(hashSet.contains(sVal)) return false;
            hashSet.add(sVal);
        }

        return true;
    }
/*
"abba"
"dog cat cat dog"
 */
    public static void main(String[] args) {
        String par = "abba";
        String s = "dog cat cat dog";
        string290 obj = new string290();
        boolean b = obj.wordPattern(par, s);
        System.out.println(b);
    }
}
