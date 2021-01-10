public class dp96 {

    public int numTrees(int n){
        if(n == 0) return 1;
        if(n == 1 ) return 1;

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;++i){
            for(int j =1;j<=i;++j){
                dp[i] +=dp[i-j]*dp[j-1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        dp96 obj = new dp96();
        int i = obj.numTrees(2);
        System.out.println(i);
    }

}
