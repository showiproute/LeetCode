import java.util.Arrays;
import java.util.Comparator;

public class sort1893 {

    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i = 0;i<ranges.length;i++){
            int l = ranges[i][0];
            int r = ranges[i][1];
            if(l <= left && left <= r) {
                left = r+1;
            }
        }

        return left > right;
    }

    public static void main(String[] args) {
        sort1893 obj = new sort1893();
        int[][] ranges = {{1,10},{10,20}};
        boolean covered = obj.isCovered(ranges, 21, 21);
        System.out.println(covered);
    }
}
