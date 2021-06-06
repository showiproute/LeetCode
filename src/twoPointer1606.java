import java.util.Arrays;

public class twoPointer1606 {

    // 1 2 3 11 15
    // 8 19 23 127 235
    public int smallestDifference(int[] a, int[] b) {
        if(a == null || b == null) return 0;
        Arrays.sort(a);
        Arrays.sort(b);
        int aLength = a.length;
        int bLength = b.length;
        int i = 0,j = 0;
        long minVal = Integer.MAX_VALUE;
        while (i < aLength && j < bLength) {
            long aVal = a[i];
            long bVal = b[j];
            long abs = Math.abs(aVal - bVal);
            if(abs <= minVal) {
                minVal = abs;
            }
            if(aVal >= bVal) {
                j++;
            }else{
                i++;
            }
        }

        return (int)minVal;
    }

//[-2147483648,1]
//[2147483647,0]
    public static void main(String[] args) {
        int[] A = {-2147483648,1};
        int[] B = {2147483647,0};
        twoPointer1606 obj = new twoPointer1606();
        int i = obj.smallestDifference(A, B);
        System.out.println(i);
    }

}
