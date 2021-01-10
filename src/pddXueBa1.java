import java.util.Scanner;

public class pddXueBa1 {

//    public static int solution(int n ){
//        if(n<=0) return 0;
//        int[] arr = new int[n];
//        for(int i = 0;i<n;i++){
//            arr[i] = i+1;
//        }
//        int cnts = 0;
//        while(true){
//            int val = helper(arr);
//            if(val == 0) break;
//            cnts++;
//            minusVal(arr,val);
//        }
//
//
//        return cnts;
//    }
//
//
//    public static int helper(int[] nums) {
//        float cnts = 0;
//        long sums =0;
//        for(int i= 0;i<nums.length;i++){
//            if(nums[i] !=0){
//                cnts++;
//                sums+=nums[i];
//            }
//        }
//
//        return Math.round(sums/cnts);
//    }
//
//    public static void minusVal(int[] nums,int val){
//        for(int i = 0;i<nums.length;i++){
//            if(nums[i] >= val) {
//                nums[i]-=val;
//            }
//        }
//    }

    public static long solution(long n) {
        long cnts = 0;
        while (n!=0){
            cnts ++;
            n = n/2;
        }

        return cnts;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int T = sc.nextInt();
            for(int i= 0 ;i<T;i++){
                long solution = solution(sc.nextLong());
                System.out.println(solution);
            }
        }
    }
}
