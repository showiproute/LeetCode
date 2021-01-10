import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class pinduoduo3 {

    public static HashMap<Integer,String[][]> rst = new HashMap<>();

    public static void solution(ArrayList<String> inputList,int m){
        if(m == 2) {
            System.out.println(2);
            System.out.println("|"+3);
            System.out.println("^"+2);
        }

        int maxValue = (int) (Math.pow(2,m)-1);
        int[] keys = new int[maxValue+1];
        for(int i = 0;i<keys.length;i++){
            keys[i] = i;
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0;i<keys.length;i++){
            int value = compute(inputList, keys[i]);
            hashMap.put(keys[i],value);
        }

        //process
        int length = inputList.size();

    }

    public static int compute(ArrayList<String> inputList,int num) {
        int sum = num;
        for(int i = 0;i<inputList.size();i++){
            String[] fields = inputList.get(i).split(" ");
            int opsValue = Integer.parseInt(fields[1]);
            if(fields[0].equals('|'+"")) {
                sum = sum | opsValue;
            }else if(fields[0].equals('&'+"")){
                sum = sum&opsValue;
            }else if(fields[0].equals('^'+"")){
                sum = sum^opsValue;
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0;i<n;i++){
                list.add(sc.nextLine());
            }
            solution(list,m);
        }

    }
}

