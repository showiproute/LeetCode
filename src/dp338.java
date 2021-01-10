public class dp338 {

    public int[] countBits(int num) {
        if(num == 0) return new int[]{0};
        if(num == 1) return new int[]{0,1};
        if(num == 2) return new int[]{0,1,1};
        int[] dp = new int[num+1];

        int i=0,b=1;
        while(b<=num) {
            while(i<b && i+b<=num) {
                dp[i+b] = dp[i]+1;
                ++i;
            }
            i=0;
            b<<=1;
        }

        return dp;
    }

}
