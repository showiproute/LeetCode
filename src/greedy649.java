import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class greedy649 {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for(int i= 0;i<senate.length();i++){
            if(senate.charAt(i) == 'D') {
                dire.offer(i);
            }else{
                radiant.offer(i);
            }
        }
        int length = senate.length();

        while(!radiant.isEmpty() && !dire.isEmpty()){
            Integer ra = radiant.poll();
            Integer dir = dire.poll();
            if(ra < dir) {
                radiant.offer(ra+length);
            }else{
                dire.offer(dir+length);
            }
        }

        if(radiant.isEmpty()) return "Dire";
        if(dire.isEmpty()) return "Radiant";

        return "";
    }

    public static void main(String[] args) {
        greedy649 obj = new greedy649();
        String rd = obj.predictPartyVictory("DRRDRDRDRDDRDRDR");
        System.out.println(rd);
    }

}
