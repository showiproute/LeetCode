import java.util.Arrays;
import java.util.Scanner;

public class pdd3 {
    public static int solution(int n) {
        if(n == 0) return 0;
        if(n ==1 ) return 1;
        if(n == 2) return 2;
        return 1+solution(n/2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int T = sc.nextInt();
            for(int i=  0;i<T;i++){
                int n = sc.nextInt();
                System.out.println(solution(n));
            }

        }
    }
}
