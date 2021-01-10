import java.util.Arrays;
import java.util.Comparator;

public class greedy452 {

    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length ==0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int end = (int) (points[0][1] % 1e9);
        int counts = 1;
        for(int i= 0 ;i<points.length;i++){
            if(points[i][0] > end) {
                counts++;
                end = (int) (points[i][1] % 1e9);
            }
        }

        return counts;
    }

    public static void main(String[] args) {
        int[][] points = {
                {-2147483646,-2147483645},
                {2147483646,2147483647},
        };
        greedy452 obj = new greedy452();
        int minArrowShots = obj.findMinArrowShots(points);
        System.out.println(minArrowShots);
        System.out.println(Arrays.toString(points));
    }

}
