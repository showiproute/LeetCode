import java.util.Arrays;

public class array976 {

    public int largestPerimeter(int[] A) {
        if(A == null || A.length == 0) return 0;
        Arrays.sort(A);
        int maxSize = 0;

        int i = 0;
        int j = 2;
        while(j<A.length) {
            //
            if( A[i]+A[i+1] > A[i+2]){
                maxSize = Math.max(maxSize,A[i]+A[i+1]+A[i+2]);
            }
            i++;
            j++;
        }

        return maxSize;
    }
    //2 3 3 4

    public static void main(String[] args) {
        int[] arr = {3,6,2,3};
        array976 obj = new array976();
        int i = obj.largestPerimeter(arr);
        System.out.println(i);
    }


}
