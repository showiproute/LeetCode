public class string43 {

    //输入: num1 = "123", num2 = "456"
    //输出: "56088"
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) return "0";

        int m = num1.length();
        int n = num2.length();
        String ans = "0";
        for(int i = n-1;i>=0;i--){
            StringBuilder sb = new StringBuilder();
            for(int j = n-1;j>i;j--){
                sb.append("0");
            }
            int val = num2.charAt(i) - '0';
            int add = 0;
            for(int j = m-1;j>=0;j--){
                int x = (num1.charAt(j) - '0')*val+add;
                sb.append(x%10);
                add = x/10;
            }
            if(add != 0) {
                sb.append(add);
            }
            ans = helper(ans,sb.reverse().toString());
        }

        return ans;
    }

    public String helper(String ans,String num) {
        int m = ans.length();
        int n = num.length();
        StringBuilder rst = new StringBuilder();
        int add =0;
        for(int i = n-1;i>=0;i--){
            int x = 0;
            if(m>0){
                x = ans.charAt(m - 1) - '0';
                m--;
            }
            int y = num.charAt(i)-'0';
            rst.append((x+y+add)%10);
            add = (x+y+add) / 10;
        }
        if(add != 0) {
            rst.append(add);
        }

        return rst.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "123456789";
        String num2 = "987654321";
        string43 obj = new string43();
        String multiply = obj.multiply(num1, num2);
        System.out.println(multiply);

    }

}
