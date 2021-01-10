import java.util.Scanner;

public class jinZhiZhuanHuan {

    public String solution(int M,int N,String inputStr) {
        int inputStrNum = getInputStrNum(M, inputStr);
        return transToNProcess(N, inputStrNum);
    }

    public int getInputCharNum(char c) {
        if(c>='a' && c<='z') {
            return c-'a'+10;
        }
        if(c>='0' && c<='9') {
            return c-'0';
        }

        return -1;
    }
    public char getInputNumChar(int num) {
        if(num >= 0 && num <= 9) {
            return (char) ('0'+num);
        }else if(num >= 10 && num<= 36) {
            return (char) ('a'-10+num);
        }else{
            return '#';
        }
    }

    //转换成10进制数
    public int getInputStrNum(int M,String inputStr) {
        int sum = 0;
        int len = inputStr.length();
        for(int i = 0;i<inputStr.length();i++){
            len--;
            int num = getInputCharNum(inputStr.charAt(i));
            sum+=num*Math.pow(M,len);
        }

        return sum;
    }

    //转换成n进制数
    public String transToNProcess(int N,int sum) {
        StringBuilder sb = new StringBuilder();
        while(sum!=0) {
            int rest = sum%N;
            sum = sum/N;
            sb.append(getInputNumChar(rest));
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        jinZhiZhuanHuan obj = new jinZhiZhuanHuan();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            sc.nextLine();
            String inputStr = sc.nextLine();
            boolean flag = false;
            if(inputStr.charAt(0) == '-') {
                flag = true;
                inputStr = inputStr.substring(1);
            }
            String solution = obj.solution(M, N, inputStr);
            if(flag) {
                System.out.println("-"+solution);
            }else{
                System.out.println(solution);
            }
        }
    }

}
