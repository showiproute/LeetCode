import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class string187 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> rst = new ArrayList<>();
        if(s == null || s.length() <=10) return rst;
        HashSet<String> visited = new HashSet<>();
        for(int i =0 ;i<s.length()-10;i++){
            String substring = s.substring(i, i + 10);
            if(visited.contains(substring) && !rst.contains(substring)) {
                rst.add(substring);
            }else{
                visited.add(substring);
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        string187 obj = new string187();
        List<String> repeatedDnaSequences = obj.findRepeatedDnaSequences(s);
        System.out.println(repeatedDnaSequences.toString());
    }
}
