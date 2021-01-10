import java.util.Arrays;
import java.util.Comparator;

public class greedy435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length ==0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int counts= 1 ;
        int before_end = intervals[0][1];
        for(int i =1;i<intervals.length;i++){
            if(intervals[i][0]>=before_end) {
                counts++;
                before_end = intervals[i][1];
            }
        }


        return intervals.length-counts;
    }

    public static void main(String[] args) {
        int[][] arr  = {
                {1,100},
                {11,22},
                {1,11},
                {2,12}
        };
        greedy435 obj = new greedy435();
        int i = obj.eraseOverlapIntervals(arr);
        System.out.println(i);
    }
}
