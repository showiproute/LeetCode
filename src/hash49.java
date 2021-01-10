import java.util.*;

public class hash49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        HashMap<String,List<String>> hashMap = new HashMap<>();
        for(int i =0 ;i<strs.length;i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String key = Arrays.toString(charArray);
            if(hashMap.containsKey(key)) {
                List<String> list = hashMap.get(key);
                list.add(strs[i]);
                hashMap.put(key,list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hashMap.put(key,list);
            }
        }

        List<List<String>> rst = new ArrayList<>();
        for(Map.Entry<String,List<String>> keyValue : hashMap.entrySet()) {
            rst.add(keyValue.getValue());
        }

        return rst;
    }

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        hash49 obj = new hash49();
        List<List<String>> lists = obj.groupAnagrams(arr);
        System.out.println(lists.toString());
    }



}
