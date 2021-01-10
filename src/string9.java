public class string9 {

    public boolean isPalindrome(int x) {
        String s = x+"";
        int i = 0;
        int j = s.length()-1;
        while(i<=j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        string9 obj = new string9();
        boolean palindrome = obj.isPalindrome(-121);
        System.out.println(palindrome);

    }
}
