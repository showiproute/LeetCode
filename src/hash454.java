import java.util.HashMap;

public class hash454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A == null || B == null || C == null || D == null) return 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0;i<A.length;i++){
            for(int j =0;j<B.length;j++){
                hashMap.put(A[i]+B[j],hashMap.getOrDefault(A[i]+B[j],0)+1);
            }
        }
        int counts= 0;
        for(int i =0;i<C.length;i++){
            for(int j =0;j<D.length;j++){
                if(hashMap.containsKey(-C[i]-D[j])){
                    counts+=hashMap.getOrDefault(-C[i]-D[j],0);
                }
            }
        }

        return counts;
    }

    public static void main(String[] args) {
        //[-1,-1]
        //[-1,1]
        //[-1,1]
        //[1,-1]
        int[] A = {-1,-1};
        int[]B = {-1,1};
        int[]C = {-1,1};
        int[] D= {1,-1};
        hash454 obj=  new hash454();
        int i = obj.fourSumCount(A, B, C, D);
        System.out.println(i);
    }

}
