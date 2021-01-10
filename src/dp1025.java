public class dp1025 {

    public boolean divisorGame(int N) {
        if(N ==1 ) return false;
        if(N == 2) return true;
        int[] dp = new int[N+1];

        //自底向上
        dp[1] = 0;
        dp[2] = 1;

        for(int i =3;i<=N;i++){
            for(int j=1;j<i/2;j++){
                if(i%j == 0 && dp[i-j] ==0){
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[N] != 0;
    }

    public static void main(String[] args) {
        dp1025 obj = new dp1025();
        boolean b = obj.divisorGame(5);
        System.out.println(b);
    }



}
