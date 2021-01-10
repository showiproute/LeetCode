public class factorial1137 {

    public int tribonacci(int n) {
        if(n<=2){
            if(n == 0) return 0;
            if(n == 1) return 1;
            if(n == 2) return 1;
        }
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        int t3 = 2;
        for(int i=3;i<=n;i++){
            t3 = t0+t1+t2;
            t0 = t1;
            t1 = t2;
            t2 = t3;
        }

        return t3;
    }

    public static void main(String[] args) {
        factorial1137 obj = new factorial1137();
        int tribonacci = obj.tribonacci(25);
        System.out.println(tribonacci);

    }


}
