import java.util.*;

public class string1370 {

    public String sortString(String s) {
        StringBuilder sb = new StringBuilder();
        if(s == null || s.length() ==0 ) return sb.toString();
        TreeMap<Character,Integer> hashMap = new TreeMap<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1-o2;
            }
        });
        HashSet<Character> visited = new HashSet<>();
        //init
        for(int i=0;i<s.length();i++){
            if(hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i),hashMap.getOrDefault(s.charAt(i),0)+1);
            }else{
                hashMap.put(s.charAt(i),1);
            }
            visited.add(s.charAt(i));
        }



        while(!visited.isEmpty()) {
            //最小到最大
            for(Character key : hashMap.keySet()) {
                Integer value = hashMap.get(key);
                if(value == 0) {
                    visited.remove(key);
                    continue;
                }
                hashMap.put(key,value-1);
                sb.append(key);
            }
            //最大到最小
            StringBuilder temp = new StringBuilder();
            for(Character key : hashMap.keySet()) {
                Integer value = hashMap.get(key);
                if(value == 0) {
                    visited.remove(key);
                    continue;
                }
                hashMap.put(key,value-1);
                temp.append(key);
            }
            sb.append(temp.reverse().toString());
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        String inputStr= "leetcode";
        string1370 obj = new string1370();
        String s = obj.sortString(inputStr);
        System.out.println(s);
    }


}
