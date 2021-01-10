public class digit461 {

    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int counts= 0 ;
        while(xor!=0) {
            if(xor % 2==1){
                counts++;
            }
            xor = xor >> 1;
        }

        return counts;
    }
    public static void main(String[] args) {
        digit461 obj = new digit461();
        int i = obj.hammingDistance(1, 4);
        System.out.println(i);
    }

}
