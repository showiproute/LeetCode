import java.util.ArrayList;
import java.util.Scanner;

public class pddXueBa2 {

//    //暴力破解会超时 注意n的取之范围
//    public static int minVal = Integer.MAX_VALUE;
//    public static int maxVal = Integer.MIN_VALUE;
//    public static void solution(int n) {
//        int[] nums = new int[n];
//        minVal = Integer.MAX_VALUE;
//        maxVal = Integer.MIN_VALUE;
//        for(int i= 0 ;i<n;i++){
//            nums[i] = i+1;
//        }
//        backTracking(nums,new ArrayList<>());
//        System.out.println(minVal + " " +maxVal);
//    }
//
//    public static void backTracking(int[] nums, ArrayList<Integer> temp) {
//        if(temp.size() == nums.length) {
//            int val = helper(temp);
//            minVal = Math.min(minVal,val);
//            maxVal = Math.max(maxVal,val);
//            return;
//        }
//        for(int i = 0;i<nums.length;i++){
//            if(temp.contains(nums[i])) continue;
//            temp.add(nums[i]);
//            backTracking(nums,temp);
//            temp.remove(temp.size()-1);
//         }
//    }
//
//    public static int helper(ArrayList<Integer> temp) {
//        int length = temp.size();
//        ArrayList<Integer> store = new ArrayList<>();
//        store.add(temp.get(0));
//        for(int i = 1;i<length;i++){
//            int val = Math.abs(store.get(i - 1) - temp.get(i));
//            store.add(val);
//        }
//
//        return store.get(length-1);
//    }

    //还是得找规律做
    public static void solution(int n ) {
        if(n == 1 || n == 2) {
            System.out.println("1" + " " + "1");
            return;
        }

        int min = getMin(n);
        int max = n - getMin(n-1);
        System.out.println(min + " " + max);
    }

    public static int getMin(int n) {
        if(n % 4 == 1 || n % 4 == 2) return 1;
        if(n % 4 ==3 || n % 4 == 0) return 0;
        return -1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int T = sc.nextInt();
            for(int  i = 0;i<T;i++){
                solution(sc.nextInt());
            }
        }


    }
}
