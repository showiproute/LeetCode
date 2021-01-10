import java.util.Arrays;

public class greedy455 {

    public int findContentChildren(int[] g, int[] s) {
        if(g == null || g.length == 0 || s == null || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int counts = 0;
        for(int i = 0;i<s.length;i++){
            if(counts < g.length && s[i] >= g[counts]) {
                counts++;
            }
        }

        return counts;
    }

    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s = {1,2,3};
        greedy455 obj = new greedy455();
        int contentChildren = obj.findContentChildren(g, s);
        System.out.println(contentChildren);
    }



}
