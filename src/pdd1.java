import java.util.Arrays;
import java.util.Scanner;

public class pdd1 {

    public static void solution(int n ){
        if(n < 3 || n > 200) return;
        int[][] rst = new int[n][n];
        //1
        rst[0][(n+1)/2] = 1;
        //2
        rst[0][n/2-1] = 2;
        //3
        rst[n/2-1][0] = 3;
        //4
        rst[(n+1)/2][0] = 4;
        //5
        rst[n-1][n/2-1] = 5;
        //6
        rst[n-1][(n+1)/2] = 6;
        //7
        rst[(n+1)/2][n-1] = 7;
        //8
        rst[n/2-1][n-1] = 8;
        for(int i = 0;i<rst.length;i++){
            System.out.println(Arrays.toString(rst[i]));
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            solution(n);
        }

    }
}
