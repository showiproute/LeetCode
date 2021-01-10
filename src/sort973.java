import java.util.*;

public class sort973 {

    public int[][] kClosest(int[][] points, int K) {
        if(points == null || points.length ==0 || K<=0) return new int[][]{};
        int[][] rst = new int[K][2];
        HashMap<int[], Integer> hashMap = new HashMap<>();
        for(int i =0 ;i<points.length;i++){
            int distance = (int)Math.pow(points[i][0],2)+(int)Math.pow(points[i][1],2);
            hashMap.put(points[i],distance);
        }
        ArrayList<Map.Entry<int[], Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<int[], Integer>>() {
            @Override
            public int compare(Map.Entry<int[], Integer> o1, Map.Entry<int[], Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });

        for(int i = 0;i<K;i++){
            Map.Entry<int[], Integer> keyValue = list.get(i);
            rst[i] = keyValue.getKey();
        }

        return rst;
    }

    public static void main(String[] args) {
//输入：points = [[3,3],[5,-1],[-2,4]], K = 2
        int[][] arr= {
            {3,3},
            {5,-1},
            {-2,4}
        };
        sort973 obj = new sort973();
        int[][] ints = obj.kClosest(arr, 2);
        for(int i =0;i<ints.length;i++){
            System.out.println(Arrays.toString(ints[i]));
        }
    }

}
