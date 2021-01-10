import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class sort1030 {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        ArrayList<int[]> store= new ArrayList<>();
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                int[] value = {i,j};
                store.add(value);
            }
        }

        Collections.sort(store, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int a = Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0);
                int b = Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0);
                return a-b;
            }
        });

        int[][] rst = new int[store.size()][2];
        for(int i = 0;i<store.size();i++){
            rst[i] = store.get(i);
        }

        return rst;
    }

    public static void main(String[] args) {
        sort1030 obj = new sort1030();
        int[][] ints = obj.allCellsDistOrder(2, 2, 0, 1);
        for(int i = 0;i<ints.length;i++){
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}
