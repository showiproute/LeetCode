import java.util.HashSet;

public class hashSet1893 {

    public boolean isCovered(int[][] ranges, int left, int right) {
        HashSet<Integer> vals = new HashSet<>();
        for(int i = 0;i<ranges.length;i++){
            for(int j = 0;j<ranges[i].length;j++){
                if(ranges[i][0] == ranges[i][1]) break;
                vals.add(ranges[i][j]);
            }
        }

        for(int i = left;i<=right;i++){
            if(vals.contains(i)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        hashSet1893 obj = new hashSet1893();
        int[][] ranges = {{1,10},{10,20}};
        boolean covered = obj.isCovered(ranges, 21, 21);
        System.out.println(covered);
    }
}
