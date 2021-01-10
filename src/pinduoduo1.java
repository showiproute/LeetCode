import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class pinduoduo1 {

    public static int first ;
    public static  int last;
    public static void solution(int[] arr, int m){
        if(arr == null || arr.length ==0 || m<0) {
            System.out.print(-1);
            return;
        }

        Arrays.sort(arr);
        int min = Math.max(arr[0] - m, 0);
        int max = arr[arr.length-1]+m;
        ArrayList<Integer> rst = new ArrayList<>();
        first = arr[0];
        last = arr[arr.length-1];

        for(int i = min;i<=max;i++){
            if(helper(i,m)){
                rst.add(i);
            }
        }

        if(rst.size() == 0) {
            System.out.print(-1);
        }else{
            System.out.print(rst.get(0));
            System.out.print(" ");
            System.out.print(rst.get(rst.size()-1));
        }
    }

    public static boolean helper(int num,int m) {
        int a = Math.abs(num - first);
        int b = Math.abs(num - last);

        return a <=m && b<=m;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while(sc.hasNext()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] arr = new int[N];
            for(int i = 0;i<N;i++){
                arr[i] = sc.nextInt();
            }
            solution(arr,M);
        }


    }
}
