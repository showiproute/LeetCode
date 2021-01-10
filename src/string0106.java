public class string0106 {

    public String compressString(String S) {
        if(S == null || S.length() ==0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<S.length();){
            char ch = S.charAt(i);
            int j = i+1;
            while(j<S.length() && ch == S.charAt(j) ) {
                j++;
            }
            sb.append(ch).append(j-i);
            i=j;
        }
        return sb.length() > S.length() ? S : sb.toString();
    }

    public static void main(String[] args) {
        String inputStr = "aabcccccaaa";
        string0106 obj = new string0106();
        String s = obj.compressString(inputStr);
        System.out.println(s);
    }
}
