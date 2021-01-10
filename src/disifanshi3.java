import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class disifanshi3 {
    public static int solution(int[] array,int left,int right) {
        if(array == null || array.length ==0) return 0;
        if(left == right) return 1;

        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = left;i<=right;i++) {
            hashSet.add(array[i]);
        }
//        System.out.println(hashSet.toString());
        return hashSet.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            sc.nextLine();
            String[] s = sc.nextLine().split(" ");
            int[] array = new int[n];
            for(int i = 0;i<s.length;i++){
                array[i] = Integer.parseInt(s[i]);
            }
            for(int i = 0;i<q;i++){
                String[] s1 = sc.nextLine().split(" ");
                int left = Integer.parseInt(s1[0]);
                int right = Integer.parseInt(s1[1]);
                int solution = solution(array, left, right);
                System.out.println(solution);
            }
        }
    }
}
