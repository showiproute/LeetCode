public class dp0801 {

    public int waysToStep(int n) {
        if( n == 0) return 0;
        if(n ==1) return 1;
        if( n ==2 ) return 2;
        if(n ==3 ) return 4;
        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] =2;
        dp[3] = 4;
        for(int i = 4;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%1000000007;
        }

        return (int)dp[n];
    }

    public static void main(String[] args) {
        dp0801 obj  = new dp0801();
        int i = obj.waysToStep(5);
        System.out.println(i);
    }
}
