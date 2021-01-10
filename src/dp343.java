public class dp343 {

    public int integerBreak(int n) {
        if(n == 1) return 1;
        if(n ==2 )return 1;
        if(n ==3 ) return 2;
        if(n == 4) return 4;

        int a = n /3;
        int b = n %3;

        if(b == 0) return (int) Math.pow(3,a);
        if(b == 1) return (int) Math.pow(3,a-1)*4;
        if(b == 2) return (int) Math.pow(3,a)*b;

        return 0;
    }

    public static void main(String[] args) {
        dp343 obj = new dp343();
        int i = obj.integerBreak(10);
        System.out.println(i);
    }
}
