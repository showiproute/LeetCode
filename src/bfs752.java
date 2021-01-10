import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class bfs752 {

    public String upDigit(String origin,int index){
        char[] charArray = origin.toCharArray();
        if(charArray[index] == '9') {
            charArray[index] = '0';
        }else{
            charArray[index] = (char) (charArray[index]+1);
        }

        return new String(charArray);
    }

    public String downDigit(String origin,int index) {
        char[] charArray = origin.toCharArray();
        if(charArray[index] == '0'){
            charArray[index] = '9';
        }else{
            charArray[index] = (char) (charArray[index]-1);
        }

        return new String(charArray);
    }

    public int openLock(String[] deadends, String target) {
        HashSet<String> deadSet = new HashSet<>(Arrays.asList(deadends));

        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer("0000");
        int times = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i =0;i<size;i++){
                String poll = queue.poll();
                if(deadSet.contains(poll)) {
                    continue;
                }
                if(poll.equals(target)) {
                    return times;
                }
                visited.add(poll);
                for(int j =0;j<4;j++){
                    String up = upDigit(poll, j);
                    String down = downDigit(poll, j);
                    if(!visited.contains(up)) {
                        visited.add(up);
                        queue.offer(up);
                    }
                    if(!visited.contains(down)){
                        visited.add(down);
                        queue.offer(down);
                    }
                }
            }
            times++;
        }

        return -1;
    }

    public static void main(String[] args) {
        bfs752 obj = new bfs752();
        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        int i = obj.openLock(deadends, "8888");
        System.out.println(i);
    }



}
