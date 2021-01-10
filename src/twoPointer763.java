import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class twoPointer763 {

    public List<Integer> partitionLabels(String S) {
        List<Integer> rst = new ArrayList<>();
        if (S == null || S.length() == 0) return rst;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            int index = i;
            for (int j = i + 1; j < S.length(); j++) {
                if (S.charAt(j) == cur) {
                    index = j;
                }
            }
            hashMap.put(cur, index);
        }

        int start = 0;
        int end = 0;
        for(int i =0;i<S.length();i++){
            end = Math.max(end,hashMap.get(S.charAt(i)));
            if(i == end) {
                rst.add(end-start+1);
                start = end+1;
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        twoPointer763 obj = new twoPointer763();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> integers = obj.partitionLabels(s);
        System.out.println(integers.toString());
    }
}
