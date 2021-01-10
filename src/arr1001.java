import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class arr1001 {

    public void merge(int[] A, int m, int[] B, int n) {
        for(int i = 0;i<n;i++){
            A[m+i] = B[i];
        }
        Arrays.sort(A);
    }

    public static void main(String[] args) {
        arr1001 obj = new arr1001();
        int[] A = {0};
        int[] B = {1};
        obj.merge(A,0,B,1);
    }
}
