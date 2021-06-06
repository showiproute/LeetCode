import java.util.PriorityQueue;

public class array495 {

    //输入: [1,4], 2
    //输出: 4
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0) return 0;
        int total = 0;
        for(int i = 0;i<timeSeries.length-1;i++){
            total += Math.min(timeSeries[i+1] - timeSeries[i],duration);
        }

        return total+duration;
    }

    public static void main(String[] args) {
        int[] ser = {1,2};
        int dur = 2;
        array495 obj = new array495();
        int poisonedDuration = obj.findPoisonedDuration(ser, dur);
        System.out.println(poisonedDuration);
    }
}
