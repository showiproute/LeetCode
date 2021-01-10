public class binarySearch50 {
    public double myPow(double x,int n ) {
        if(x == 0 || x ==1 || n ==1) return x;
        if(n == 0) return 1;
        long N = n;
        if(n < 0) {
            return 1.0 / helper(x,N);
        }else{
            return helper(x,N);
        }
    }

    public double helper(double x,long n){
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n%2 ==0) {
            double value = helper(x,n/2);
            return value*value;
        }else{
            double value = helper(x,n/2);
            return value*value*x;
        }
    }


    /*
    0.00001
2147483647
     */

    public static void main(String[] args) {
        binarySearch50 obj = new binarySearch50();
        double v = obj.myPow(2, -3);
        System.out.println(v);
    }
}
