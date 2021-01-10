public class ms415 {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i =num1.length()-1;
        int j =num2.length()-1;
        int carry = 0;
        while(i>=0 && j >=0) {
            int a = num1.charAt(i)-'0';
            int b = num2.charAt(j)-'0';
            sb.append((a+b+carry) % 10);
            if(a+b+carry >= 10) carry=1;
            else carry = 0;
            i--;
            j--;
        }
        if( i== -1 && j == -1){
            if(carry == 1){
                sb.append('1');
                return sb.reverse().toString();
            }
            return sb.reverse().toString();
        }

        if(i == -1){
            while(j>=0){
                sb.append((num2.charAt(j)-'0'+carry)%10);
                if(num2.charAt(j)-'0'+carry >= 10) {
                    carry =1;
                }else{
                    carry = 0;
                }
                j--;
            }
            if(carry == 1) {
                sb.append('1');
            }
            return sb.reverse().toString();
        }
        if(j == -1){
            while(i>=0){
                sb.append((num1.charAt(i)-'0'+carry)%10);
                if(num1.charAt(i)-'0'+carry >= 10) {
                    carry =1;
                }else{
                    carry = 0;
                }
                i--;
            }
            if(carry == 1) {
                sb.append('1');
            }
            return sb.reverse().toString();
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ms415 obj = new ms415();
        String s = obj.addStrings("999", "9");
        System.out.println(s);
    }
}
