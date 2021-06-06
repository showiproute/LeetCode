import java.util.HashSet;

public class hashSet0101 {

    public boolean isUnique(String astr) {
        if(astr == null || astr.length() ==0 ) return true;
        HashSet<Character> hashSet = new HashSet<>();
        for(int i= 0 ;i<astr.length();i++){
            if(hashSet.contains(astr.charAt(i))) return false;
            hashSet.add(astr.charAt(i));
        }

        return true;
    }



}
