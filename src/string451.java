import java.util.*;

public class string451 {

    //输入:
    //"tree"
    //
    //输出:
    //"eert"
    //
    //解释:
    //'e'出现两次，'r'和't'都只出现一次。
    //因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
    //
    public String frequencySort(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            hashMap.put(s.charAt(i),hashMap.getOrDefault(s.charAt(i),0)+1);
        }
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(hashMap.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> keyVal : list) {
            char key = keyVal.getKey();
            int val = keyVal.getValue();
            for(int i = 0;i<val;i++){
                sb.append(key);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        string451 obj = new string451();
        String eert = obj.frequencySort("Aabb");
        System.out.println(eert);

    }


}
