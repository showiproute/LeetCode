import java.util.ArrayList;
import java.util.Scanner;

public class pdd4 {
    public static ArrayList<ArrayList<Integer>> rst = new ArrayList<>();
    public static int minValue = Integer.MAX_VALUE;
    public static int maxValue = Integer.MIN_VALUE;
    public static void solution(int n ){
        if(n == 1) {
            System.out.println("1"+" "+"1");
            return;
        }
        rst = new ArrayList<>();
        minValue = Integer.MAX_VALUE;
        maxValue = Integer.MIN_VALUE;
        int[] nums = new int[n];
        for(int i= 0 ;i<nums.length;i++){
            nums[i] = i+1;
        }

        backTracking(new ArrayList<>(),nums);
        helper(n);
        System.out.println(minValue + " " + maxValue);
    }

    public static void helper(int n) {
        int[] arr = new int[n+1];
        int index = 1;
        for(int i= 0;i<rst.size();i++){
            for(int j = 0;j<rst.get(i).size();j++){
                arr[index] = rst.get(i).get(j);
                index++;
            }
            int val = compute(arr, n);
            minValue = Math.min(val,minValue);
            maxValue = Math.max(val,maxValue);
            index = 1;
        }
    }

    public static int compute(int[] arr,int index) {
        if(index == 1) return arr[1];
        return Math.abs(compute(arr,index-1)-arr[index]);
    }

    public static void backTracking(ArrayList<Integer> temp,int[] nums) {
        if(temp.size() == nums.length) {
            rst.add(new ArrayList<>(temp));
            return;
        }
        for(int i= 0 ;i<nums.length;i++){
            if(temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            backTracking(temp,nums);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int T = sc.nextInt();
            for(int i= 0 ;i<T;i++){
                int n = sc.nextInt();
                solution(n);
            }
        }
    }
}
