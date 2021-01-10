import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dp120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return 0;
        }

        int col = triangle.get(triangle.size() - 1).size();
        int row = triangle.size();

        int[][] dp = new int[row][col];
        dp[0][0] = triangle.get(0).get(0);

        //init
        for(int i=1;i<dp.length;i++){
            dp[i][0] = triangle.get(i).get(0)+dp[i-1][0];
            dp[i][i] = triangle.get(i).get(i)+dp[i-1][i-1];
        }

        for(int i = 2;i<triangle.size();i++){
            for(int j =1;j<triangle.get(i).size()-1;j++){
                dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
            }
        }

        //
//        for(int i =0;i<dp.length;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        int minValue = Integer.MAX_VALUE;
        for(int i=0;i<dp[0].length;i++){
            if(dp[dp.length-1][i] < minValue) {
                minValue = dp[dp.length-1][i];
            }
        }

        return minValue;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        ArrayList<Integer> p1 = new ArrayList<>();
        p1.add(2);
        ArrayList<Integer> p2 = new ArrayList<>();
        p2.add(3);
        p2.add(4);
        ArrayList<Integer> p3 = new ArrayList<>();
        p3.add(6);
        p3.add(5);
        p3.add(7);
        ArrayList<Integer> p4 = new ArrayList<>();
        p4.add(4);
        p4.add(1);
        p4.add(8);
        p4.add(3);
        input.add(p1);
        input.add(p2);
        input.add(p3);
        input.add(p4);
        dp120 obj = new dp120();
        int i = obj.minimumTotal(input);
        System.out.println(i);

    }
}
