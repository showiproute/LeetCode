import java.util.Arrays;
import java.util.Comparator;

public class block1288 {

    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o2[1]-o1[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });

        int left = intervals[0][0];
        int right = intervals[0][1];
        int counts = 0;
        for(int i =1;i<intervals.length;i++){
            if(intervals[i][0] >= left && intervals[i][1] <= right) {
                counts++;
            }else if(intervals[i][0] >=left && intervals[i][1] > right) {
                right = intervals[i][1];
            }else if(intervals[i][0] > right) {
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        return intervals.length-counts;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,4},
                {3,6},
                {2,8}
        };
        block1288 obj = new block1288();
        int i = obj.removeCoveredIntervals(arr);
        System.out.println(i);
    }

}
