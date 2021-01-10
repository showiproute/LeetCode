import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class dp983 {

    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || costs == null) return 0;
        int maxDay = days[days.length-1];
        int minDay = days[0];
        int[] dp = new int[maxDay+31];

        HashSet<Integer> set = new HashSet<>();
        for(Integer day :days) {
            set.add(day);
        }

        for(int i = maxDay;i>=minDay;i--) {
            if(!set.contains(i)) {
                dp[i] = dp[i+1];
            }else{
                int a = Math.min(costs[0] + dp[i+1], costs[1] + dp[i + 7]);
                dp[i] = Math.min(a,costs[2]+dp[i+30]);
            }
        }
        System.out.println(Arrays.toString(dp));

        return dp[minDay];
    }

    public static void main(String[] args) {
        dp983 obj = new dp983();
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        int i = obj.mincostTickets(days, costs);
        System.out.println(i);
    }
}
