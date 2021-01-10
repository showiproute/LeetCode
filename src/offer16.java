public class offer16 {

    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        long temp = n;
        if(n < 0) {
            temp = -temp;
            x = 1/x;
        }
        double res = 1.0;
        while(temp>0) {
            if(temp%2 != 0){
                res*=x;
            }
            temp = temp/2;
            x*=x;
        }

        return res;
    }

    public static void main(String[] args) {
        offer16 obj = new offer16();
        double v = obj.myPow(2.00000, -3);
        System.out.println(v);
        System.out.println(2>>1);
    }
}
