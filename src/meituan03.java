import java.util.Scanner;

public class meituan03 {

    public static  int maxSubValue(int n,String inputStr) {
        int maxValue = 0;
        for(int i = 0;i<n;i++){
            int e = 0;
            int f = 0;
            if(inputStr.charAt(i) == 'e') {
                e++;
            }else{
                f++;
            }
            System.out.println(e);
            maxValue = Math.max(maxValue,e-f);
            for(int j=i+1;j<n;j++) {
                if(inputStr.charAt(j) == 'e') {
                    e++;
                }else{
                    f++;
                }
                System.out.println(e);
                maxValue = Math.max(maxValue,e-f);
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            String inputStr = sc.nextLine();
            int i = maxSubValue(n, inputStr);
            System.out.println(i);
        }
    }
}
