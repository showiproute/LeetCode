public class digit1688 {

    public int numberOfMatches(int n) {
        int cnts =0 ;
        while (n!=1) {
            if(n%2 == 0) {
                n = n/2;
                cnts+=n;
            }else{
                cnts+=n/2;
                n = n/2+1;
            }
        }

        return cnts;
    }

    public static void main(String[] args) {
        digit1688 obj = new digit1688();
        int i = obj.numberOfMatches(3);
        System.out.println(i);

    }


}
