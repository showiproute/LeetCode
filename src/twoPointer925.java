public class twoPointer925 {


    public boolean isLongPressedName(String name, String typed) {
        if(name == null || typed == null || name.charAt(0) != typed.charAt(0)) return  false;
        if(name.equals(typed)) return true;

        int i = 1;
        int j = 1;
        while(i < name.length() && j < typed.length()) {
            char x = name.charAt(i);
            char y = typed.charAt(j);
            if(x == y) {
                i++;
                j++;
            }else {
                char before= typed.charAt(j-1);
                while(j< typed.length() && typed.charAt(j) == before ){
                    j++;
                }
                if(j < typed.length() && typed.charAt(j) != x ){
                    return false;
                }
            }
        }

        if(i == name.length() && j == typed.length()) return true;
        if(i<name.length()) return false;
        if(j<typed.length()) {
            char before = typed.charAt(j-1);
            for(int k = j;k<typed.length();k++){
                if(typed.charAt(k) != before) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String name = "lb";
        String typed = "la";
        twoPointer925 obj = new twoPointer925();
        boolean longPressedName = obj.isLongPressedName(name, typed);
        System.out.println(longPressedName);
    }


}
