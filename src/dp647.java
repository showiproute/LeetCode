public class dp647 {

    public int countSubstrings(String s) {
        int counts = 0;
        for(int i = 0;i<s.length();i++){
            for(int j = i+1;j<=s.length();j++){
                String temp = s.substring(i, j);
                if(isHuiWenString(temp)){
                    counts++;
                }
            }
        }

        return counts;
    }


    public boolean isHuiWenString(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<=j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        dp647 obj = new dp647();
        int abc = obj.countSubstrings("aaa");
        System.out.println(abc);
    }
}
