import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class tencent2 {

    public static int[] solution(int[] arr,int length) {
        int[] rst = new int[length];
        Stack<Integer> leftStack = new Stack<>();
        leftStack.push(Integer.MIN_VALUE);
        Stack<Integer> rightStack = new Stack<>();
        rightStack.push(Integer.MIN_VALUE);
        for(int i= 0;i<arr.length;i++){
            //left
            for(int j=i-1;j>=0;j--){
                if(arr[j] > leftStack.peek()){
                    leftStack.push(arr[j]);
                }
            }
            int left_size = leftStack.size()-1;
            //right
            for(int k=i+1;k<arr.length;k++){
                if(arr[k] > rightStack.peek()){
                    rightStack.push(arr[k]);
                }
            }
            int right_size = rightStack.size()-1;
            rst[i] = left_size+right_size+1;
            //init
            leftStack = new Stack<>();
            leftStack.push(Integer.MIN_VALUE);
            rightStack = new Stack<>();
            rightStack.push(Integer.MIN_VALUE);
        }

        return rst;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int length = sc.nextInt();
            sc.nextLine();
            String[] s = sc.nextLine().split(" ");
            int[] arr = new int[length];
            for(int i =0;i<length;i++){
                arr[i] = Integer.parseInt(s[i]+"");
            }
            int[] solution = solution(arr, length);
            int i =0;
            for(;i<solution.length-1;i++){
                System.out.print(solution[i]+" ");
            }
            System.out.print(solution[i]);
        }
    }

}