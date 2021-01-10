import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class array1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if(arr2 == null || arr2.length == 0) return arr1;
        //init
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        ArrayList<Integer> rst = new ArrayList<>();
        for(int i = 0 ;i<arr2.length;i++){
            int cnts = getNumOfArray1(arr2[i], arr1);
            for(int j = 0;j<cnts;j++){
                rst.add(arr2[i]);
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0;i<arr1.length;i++){
            if(!set.contains(arr1[i])) {
                int cnts = getNumOfArray1(arr1[i], arr1);
                for(int j =0;j<cnts;j++){
                    temp.add(arr1[i]);
                }
                set.add(arr1[i]);
            }
        }
        Collections.sort(temp);

        int[] retArr = new int[rst.size()+temp.size()];
        int counts = 0;
        for(Integer item : rst) {
            retArr[counts] = item;
            counts++;
        }
        for(Integer item: temp) {
            retArr[counts] = item;
            counts++;
        }

        return retArr;
    }

    public int getNumOfArray1(int target,int[] arr1) {
        int counts = 0;
        for(int i = 0;i<arr1.length;i++){
            if(arr1[i] == target) {
                counts++;
            }
        }

        return counts;
    }

    /*
[28,6,22,8,44,17]
[22,28,8,6]
 */
    public static void main(String[] args) {
        int[] arr1 = {28,6,22,8,44,17};
        int[] arr2 = {22,28,8,6};
        array1122 obj = new array1122();
        int[] ints = obj.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(ints));
    }
}
