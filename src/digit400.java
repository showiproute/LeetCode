public class digit400 {

    public int findNthDigit(int n) {
        if(n <=0 ) return 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(i);
        }
//        System.out.println(sb.toString());
        return Integer.parseInt(sb.charAt(n-1) + "");
    }

    public static void main(String[] args) {
        digit400 obj = new digit400();
        int nthDigit = obj.findNthDigit(3);
        System.out.println(nthDigit);
    }


}
