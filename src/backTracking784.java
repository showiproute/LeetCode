import java.util.ArrayList;
import java.util.List;

public class backTracking784 {

    public List<String> rst = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        char[] charArray = s.toLowerCase().toCharArray();
        dfs(charArray,0,"");

        return rst;
    }

    public void dfs(char[] array,int index,String temp) {
        if(index == array.length) {
            rst.add(temp);
            return;
        }

        dfs(array,index+1,temp+array[index]);
        if(Character.isLetter(array[index])) {
            dfs(array,index+1,temp+(char)(array[index]-('a'-'A')));
        }
    }

    public static void main(String[] args) {
        backTracking784 obj = new backTracking784();
        List<String> a1b2 = obj.letterCasePermutation("a1b2");
        System.out.println(a1b2);
    }

}
