public class windows424 {

    //输入：s = "AABABBA", k = 1
    //输出：4
    public int characterReplacement(String s, int k) {
        int left =0;
        int right = 0;
        int[] store = new int[26];
        int maxSize = 0;
        char[] array = s.toCharArray();
        for(;right<s.length();right++){
            char val = array[right];
            store[val-'A']++;
            maxSize = Math.max(maxSize,store[val-'A']);
            if(right - left + 1 > maxSize + k) {
                store[array[left]-'A']--;
                left++;
            }
        }

        return s.length()-left;
    }

    //v    //输入：s = "AABABBA", k = 1
    //    //输出：4
    public static void main(String[] args) {
        windows424 obj = new windows424();
        String s = "ABAA";
        int i = obj.characterReplacement(s, 0);
        System.out.println(i);
    }
}
