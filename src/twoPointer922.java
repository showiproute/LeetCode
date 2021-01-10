import java.util.Arrays;

public class twoPointer922 {

    public int[] sortArrayByParityII(int[] A) {
        if(A == null || A.length ==0 ) return new int[]{};
        if(A.length % 2 !=0 ) return new int[]{};
        int i = 0;
        int j = 1;
        int[] rst = new int[A.length];
        for(int k = 0;k<A.length;k++){
            if(A[k]%2==0) {
                rst[i] = A[k];
                i+=2;
            }else{
                rst[j] = A[k];
                j+=2;
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        twoPointer922 obj = new twoPointer922();
        int[] ints = obj.sortArrayByParityII(arr);
        System.out.println(Arrays.toString(ints));
    }
}
