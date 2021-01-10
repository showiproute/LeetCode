public class offer14_1 {

    public int cuttingRope(int n) {
        if(n == 0) return 0;
        if(n ==1 ) return 1;
        if(n ==2) return 1;
        if(n ==3 ) return 2;

        int a = n/3;
        int b=  n%3;
        if(b == 0 ) return (int) Math.pow(3,a);
        if(b== 1) return (int) Math.pow(3,a-1)*4;
        if(b==2) return (int) Math.pow(3,a)*2;

        return -1;
    }

    public static void main(String[] args) {
        offer14_1 obj = new offer14_1();
        int i = obj.cuttingRope(10);
        System.out.println(i);
    }
}
