public class yuewen03 {

    public String removeDuplicatedChars (String str) {
        // write code here
        if(str == null || str.length() ==0) return "";
        boolean[] exists = new boolean[str.length()];
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<str.length();i++){
            if(!exists[i]){
                sb.append(str.charAt(i));
            }
            char temp = str.charAt(i);
            exists[i] = true;
            for(int j =i+1;j<str.length();j++){
                if(str.charAt(j) == temp) {
                    exists[j] = true;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        yuewen03 obj  =new yuewen03();
        String s = obj.removeDuplicatedChars("abcbdde");
        System.out.println(s);
    }

}
