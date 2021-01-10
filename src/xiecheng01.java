import java.util.ArrayList;
import java.util.Scanner;

public class xiecheng01 {

    public static int solution(String inputStr) {
        if(inputStr == null || inputStr.length() ==0) return 0;
        ArrayList<Integer> store = new ArrayList<>();
        for(int i = 0;i<inputStr.length();i++){
            int value = inputStr.charAt(i) - 'A';
            if(value >= 10) {
                store.add(value/10);
                store.add(value%10);
            }else{
                store.add(value);
            }
        }
        int[] dp = new int[store.size()];
        //base
        dp[0] = 1;
        if(store.size() >= 2) {
            int value = store.get(1);
            if(store.get(0)*10 + value >=10 && store.get(0)*10+value<=25) {
                dp[1] =2;
            }else{
                dp[1]=1;
            }
        }
        for(int i =2;i<store.size();i++){
            int cur = store.get(i);
            int before = store.get(i - 1);
            if(before*10+cur >= 10 && before*10+cur<=25) {
                dp[i]= dp[i-1]+dp[i-2];
            }else{
                dp[i] = dp[i-1];
            }
        }

        return dp[store.size()-1]-1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String inputStr = sc.nextLine();
            int solution = solution(inputStr);
            System.out.println(solution);
        }

    }
}


