import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class pddbuzhao {
    public static int solution(int n) {
        if(n<=9) return n;
        if(n>45) return -1;

        ArrayList<Integer> arrayList = new ArrayList<>();
        int val = 9;
        while (n>0) {
            if(n>=val) {
                n-=val;
                arrayList.add(val);
                val--;
            }else{
                arrayList.add(n);
                break;
            }
        }
//        System.out.println(arrayList.toString());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<arrayList.size();i++){
            sb.append(arrayList.get(i));
        }
        //test
//        System.out.println(sb.toString());
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int solution = solution(N);
            System.out.println(solution);
        }
//        int solution = solution(50);
//        System.out.println(solution);
    }
}
