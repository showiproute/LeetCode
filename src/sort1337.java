import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class sort1337 {

    public class Pointer{
        public int rows;
        public int nums;
        public Pointer(int rows,int nums){
            this.rows = rows;
            this.nums = nums;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        ArrayList<Pointer> arrayList = new ArrayList<>();
        for(int i = 0;i<mat.length;i++){
            int cnts = 0;
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j] == 0 ) {
                    break;
                }
                cnts++;
            }
            Pointer p = new Pointer(i,cnts);
            arrayList.add(p);
        }
        arrayList.sort(new Comparator<Pointer>() {
            @Override
            public int compare(Pointer o1, Pointer o2) {
                if (o1.nums == o2.nums) {
                    return o1.rows - o2.rows;
                } else {
                    return o1.nums - o2.nums;
                }
            }
        });
        int[] rst = new int[k];
        for(int i = 0;i<k;i++){
            rst[i] = arrayList.get(i).rows;
        }

        return rst;
    }

    public static void main(String[] args) {
        sort1337 obj = new sort1337();
        int[][] mat = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };
        int[] ints = obj.kWeakestRows(mat, 3);
        System.out.println(Arrays.toString(ints));

    }
}
