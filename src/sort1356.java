import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class sort1356 {

    public int[] sortByBits(int[] arr) {
        if(arr == null || arr.length == 0) return new int[]{};
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            int nums = countOnes(arr[i]);
            int[] item = {
                    arr[i],nums
            };
            list.add(item);
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0]-o2[0];
                }else{
                    return o1[1]-o2[1];
                }
            }
        });

        int[] rst = new int[list.size()];
        for(int i =0;i<list.size();i++){
            rst[i] = list.get(i)[0];
        }

        return rst;
    }

    public int countOnes(int num) {
        int counts = 0;
        while(num!=0) {
            counts+=num%2;
            num = num/2;
        }

        return counts;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8};
        sort1356 obj = new sort1356();
        int[] ints = obj.sortByBits(arr);
        System.out.println(Arrays.toString(ints));
    }

}
