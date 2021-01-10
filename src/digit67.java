public class digit67 {

    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder rst = new StringBuilder();
        int n = Math.max(a.length(),b.length());
        int carry = 0;
        for(int i = 0;i<n;i++){
            int numA = i<a.length()? a.charAt(i)-'0' : 0;
            int numB = i<b.length()? b.charAt(i)-'0' : 0;
            rst.append((numA+numB+carry) %2);
            carry = (numA+numB+carry) /2;
        }
        if(carry == 1){
            rst.append("1");
        }

        return rst.reverse().toString();
    }



    //"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
    //"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"

    public static void main(String[] args) {
        digit67 obj = new digit67();
        String a = "1010";
        String b = "1011";
        String s = obj.addBinary(a, b);
        System.out.println(s);
    }
}
