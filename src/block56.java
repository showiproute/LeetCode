import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class block56 {

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length ==0) return new int[][]{};
        ArrayList<int[]> rst = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        rst.add(intervals[0]);
        for(int i = 1;i<intervals.length;i++){
            int[] last = rst.get(rst.size() - 1);
            if(intervals[i][0] <= last[1]) {
                //update
                last[1] = Math.max(last[1],intervals[i][1]);
                rst.remove(rst.size()-1);
                rst.add(last);
            }else{
                rst.add(intervals[i]);
            }
        }

        int[][] arr = new int[rst.size()][2];
        for(int i = 0;i<rst.size();i++){
            arr[i] = rst.get(i);
        }
        return arr;
    }

//[1,3],[2,6],[8,10],[15,18]]
    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        block56 obj = new block56();
        int[][] merge = obj.merge(intervals);
        for(int i = 0;i<merge.length;i++){
            System.out.println(Arrays.toString(merge[i]));
        }
    }
}
