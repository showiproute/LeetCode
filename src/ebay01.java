import java.util.Arrays;
import java.util.Scanner;

public class ebay01 {

    static int[] array ;

    public static void solution(int left,int right,int value) {
        for(int i = left-1;i<right;i++){
            array[i]+=value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String[] s = sc.nextLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            array = new int[n];
            for(int i = 0;i<m;i++){
                String[] item = sc.nextLine().split(" ");
                int a= Integer.parseInt(item[0]);
                int b = Integer.parseInt(item[1]);
                int c = Integer.parseInt(item[2]);
                solution(a,b,c);
            }
            int j = 0;
            for(;j<array.length-1;j++){
                System.out.print(array[j]+" ");
            }
            System.out.println(array[j]);
        }
    }
}
