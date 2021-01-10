import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class pddbuzhao3 {

    public static int solution(int N,int K,int M,ArrayList<int[]> arrayList) {
        int index = 0;
        ArrayList<int[]> rst = new ArrayList<>();
        for(int[] item : arrayList) {
            int x = item[0];
            int y = item[1];
            System.out.println("index"+index+"x:"+x+"y:"+y);
            if(index>=y) {
                rst.add(new int[]{y,y+K-1});
                index = y+K-1;
            }else{
                rst.add(new int[]{x,x+K-1});
                index = x+K-1;
            }
            M--;
            if(M==0) break;
        }
        //test
        System.out.println(rst.toString());
        for(int i = 0;i<rst.size();i++){
            System.out.println("x:"+rst.get(i)[0]+"y:"+rst.get(i)[1]);
        }
//        int sum = 0;
//        int dis = 0;
//        for(int[] item : rst) {
//            int x = item[0];
//            int y = item[1];
//            if(dis < x) {
//                sum+=y-x+1;
//                dis = y;
//            }else{
//                sum+=y-dis;
//                dis =y;
//            }
//        }

        int sum = 0;
        int dis = 0;
        for(int[] item : rst) {
            int x = item[0];
            int y = item[1];
            if(dis < x) {
                dis = y;
                sum+=y-x+1;
            }else  {
                sum+=y-dis;
                dis = y;
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int T = sc.nextInt();
            for(int i= 0;i<T;i++){
                int N = sc.nextInt();
                int K = sc.nextInt();
                int M = sc.nextInt();
                sc.nextLine();
                ArrayList<int[]> arrayList = new ArrayList<>();
                for(int j = 0;j<N;j++){
                    String[] s = sc.nextLine().split(" ");
                    int x = Integer.parseInt(s[0]);
                    int y = Integer.parseInt(s[1]);
                    arrayList.add(new int[]{x,y});
                }
                Collections.sort(arrayList, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if(o1[0] == o2[0]) {
                            return o1[1]-o2[1];
                        }else{
                            return o1[0]-o2[0];
                        }
                    }
                });
                int solution = solution(N, K, M, arrayList);
                System.out.println(solution);
            }
        }
    }
}
