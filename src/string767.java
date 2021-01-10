import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class string767 {

    public class charObject {
        char ch;
        int nums;
        public charObject(char ch,int nums) {
            this.ch = ch;
            this.nums =  nums;
        }
    }

    public String reorganizeString(String S) {
        if(S == null || S.length() == 0) return "";
        PriorityQueue<charObject> queue = new PriorityQueue<>(new Comparator<charObject>() {
            @Override
            public int compare(charObject o1, charObject o2) {
                return o2.nums - o1.nums;
            }
        });
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i = 0;i<S.length();i++){
            hashMap.put(S.charAt(i),hashMap.getOrDefault(S.charAt(i),0)+1);
        }
        for(Map.Entry<Character,Integer> keyValue : hashMap.entrySet()) {
            charObject obj = new charObject(keyValue.getKey(),keyValue.getValue());
            queue.offer(obj);
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            if(queue.size() == 1) {
                charObject last = queue.poll();
                if(last.nums > 1) {
                    return "";
                }else{
                    sb.append(last.ch);
                    return sb.toString();
                }
            }
            charObject first = queue.poll();
            charObject second = queue.poll();
            if(first.nums != 1) {
                first.nums-=1;
                queue.offer(first);
            }
            if(second.nums != 1){
                second.nums -=1;
                queue.offer(second);
            }
            sb.append(first.ch);
            sb.append(second.ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        string767 obj = new string767();
        String aab = obj.reorganizeString("aaaabbcc");
        System.out.println(aab);
    }

}
