import java.util.Arrays;
import java.util.Scanner;

public class pdd2 {

    public static int[][] makeArray(int[][] arr) {
        int[][] temp = new int[arr.length][arr[0].length];
        for(int i= 0 ;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                if(arr[i][j] == 1) {
                    temp[i][j] = 1;
                }
            }
        }

        return temp;
    }
    public static int solution(int[][] arr) {
        int[][] temp = makeArray(arr);
        int rows = arr.length;
        int cols = arr[0].length;
        int maxDepth = 0;
        for(int i= 0 ;i<arr.length;i++){
            for(int j = 0;j<arr.length;j++){
                if(arr[i][j] == 1){
                    temp[i][j] = 0;
                    for(int m = 0;m<temp.length;m++){
                        for(int n = 0;n<temp[0].length;n++){
                            if(temp[m][n] ==0 ){
                                temp[m][n] = 1;
                                boolean[][] visited = new boolean[rows][cols];
                                maxDepth = Math.max(dfs(temp,m,n,visited),maxDepth);
                            }
                            temp = makeArray(arr);
                            temp[i][j] = 0;
                        }
                    }
                }
            }
        }
        //test
        System.out.println("arr");
        for(int t =0;t<temp.length;t++){
            System.out.println(Arrays.toString(arr[t]));
        }

        return maxDepth;
    }

    public static int dfs(int[][] arr,int i,int j,boolean[][] visited) {
        if(i >= arr.length || i < 0 || j < 0 || j >= arr[0].length || visited[i][j] || arr[i][j] == 0) return 0;

        visited[i][j] = true;

        return 1+dfs(arr,i+1,j,visited)+dfs(arr,i,j+1,visited)+
                dfs(arr,i-1,j,visited)+dfs(arr,i,j-1,visited);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr = new int[N][M];
            sc.nextLine();
            for(int i = 0;i<N;i++){
                String[] s = sc.nextLine().split(" ");
                for(int j = 0;j<s.length;j++){
                    if(s[j].equals("1")) {
                        arr[i][j] = 1;
                    }
                }
            }
            int solution = solution(arr);
            System.out.println(solution);
        }
    }
}
