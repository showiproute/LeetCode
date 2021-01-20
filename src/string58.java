public class string58 {

    public int lengthOfLastWord(String s) {
        if(s == null || s.length() ==0) return 0;
        String[] s1 = s.split(" ");
        if(s1.length == 0) return 0;
        return s1[s1.length-1].length();
    }

    public static void main(String[] args) {
        string58 obj = new string58();
        int i = obj.lengthOfLastWord(" ");
        System.out.println(i);

    }


}
