import java.util.Arrays;

public class twoPointer888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        if(A == null || A.length == 0 || B == null || B.length == 0) return new int[]{};
        int[] rst = new int[2];
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0,j = 0;
        while (i < A.length && j < B.length) {
            int a = A[i];
            int b = B[j];
            int[] newA = A.clone();
            int[] newB = B.clone();
            newA[i] = b;
            newB[j] = a;
            int newAsum = getSum(newA);
            int newBsum = getSum(newB);
            if(newAsum == newBsum) {
                rst[0] = A[i];
                rst[1] = B[j];
                return rst;
            }
            if(newAsum < newBsum) {
                j++;
            }else{
                i++;
            }
        }

        return new int[2];
    }


    public int getSum(int[] arr) {
        int sum = 0;
        for(int i =0 ;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }

    //    //输入：A = [1,2,5], B = [2,4]
    //    //输出：[5,4]
    public static void main(String[] args) {
        int[] A = {1,2,5};
        int[] B = {2,4};
        twoPointer888 obj = new twoPointer888();
        int[] ints = obj.fairCandySwap(A, B);
        System.out.println(Arrays.toString(ints));
    }

}
