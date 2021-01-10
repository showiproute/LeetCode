import java.util.Arrays;

public class kThNum1714 {

    public int[] smallestK(int[] arr, int k) {
        if(arr == null || arr.length ==0 || k > arr.length) return new int[]{};
        int[] ret = new int[k];
        Arrays.sort(arr);
        for(int i = 0;i<k;i++){
            ret[i] = arr[i];
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        kThNum1714 obj = new kThNum1714();
        int[] ints = obj.smallestK(arr, 4);
        System.out.println(Arrays.toString(ints));
    }
}
