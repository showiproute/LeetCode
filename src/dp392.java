public class dp392 {

    public boolean isSubsequence(String s, String t) {
        if(s.equals("")) return true;
        int i =0;
        int j =0;
        int n =s.length();
        int m = t.length();
        while(i<n && j<m) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i==n;
    }


    public static void main(String[] args) {
        dp392 obj = new dp392();
        boolean subsequence = obj.isSubsequence("abc", "ahbgdc");
        System.out.println(subsequence);
    }

}
