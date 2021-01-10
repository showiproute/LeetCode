import java.util.Arrays;
import java.util.Scanner;

public class disifanshi {

    public static int solution(int[] array,int n) {
        if(n == 0 || array.length ==0){
            return 0;
        }
        Arrays.sort(array);
        return array[3];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] s = sc.nextLine().split(" ");
            int[] array = new int[s.length];
            for(int i =0;i<s.length;i++){
                array[i] = Integer.parseInt(s[i]);
            }
            int solution = solution(array, n);
            System.out.println(solution);
        }

    }
}
