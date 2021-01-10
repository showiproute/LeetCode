public class digit5620 {

    // x = x * n ^ len2(i) + i
    public int concatenatedBinary(int n) {
        int mod  = 1000000007;
        int rst = 0;
        for(int i = 1;i<=n;i++){
            rst = (int) ((rst*Math.pow(2,lenTotalBinary(i)) + i)% mod);
        }

        return rst;
    }

    public int lenTotalBinary(int n ){
        int cnts = 0;
        while (n !=0 ){
            n = n /2;
            cnts++;
        }
        return cnts;
    }
    //1101110010111011110001001101010111100
    //1101110010111011110001001101010111100
    public static void main(String[] args) {
        digit5620 obj = new digit5620();
        int i = obj.concatenatedBinary(418);
        System.out.println(i);
    }
}

