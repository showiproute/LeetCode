import java.util.Arrays;

public class dp60 {

    //状态转移方程:
    //dp[n][i] = 西格玛{k=1 to 6} dp[n-1][i-k]; i-k>0
    //dp数字含义是 有n个骰子，总和加起来为i的出现的次数
    public double[] dicesProbability(int n) {
        int[][] dp = new int[n+1][6*n+1];
        //base case
        for(int i = 1;i<=6;i++){
            dp[1][i] = 1;
        }
        for(int i = 2;i<=n;i++){
            for(int j = i;j<=i*6;j++){
                for(int k = 1;k<=6;k++){
                    if(j-k>0) {
                        dp[i][j] += dp[i-1][j-k];
                    }else{
                        break;
                    }
                }
            }
        }

        double[] rst = new double[6*n-n+1];
        double rest = 1/Math.pow(6,n);
        int counts = 0;
        for(int i =n;i<=n*6;i++){
            rst[counts] = dp[n][i] * rest;
            counts++;
        }

        return rst;
    }

    public static void main(String[] args) {
        dp60 obj = new dp60();
        double[] doubles = obj.dicesProbability(3);
        System.out.println(Arrays.toString(doubles));

    }
}
