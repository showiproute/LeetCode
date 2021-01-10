import java.util.ArrayList;
import java.util.Arrays;

public class backTracking38 {

    ArrayList<String> rst = new ArrayList<>();
    public String[] permutation(String s) {
        if(s == null || s.length() ==0 ){
            return null;
        }
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        boolean[] visited = new boolean[charArray.length];
        dfs(charArray,visited,new StringBuilder());
        String[] result = new String[rst.size()];
        for(int i = 0;i<rst.size();i++){
            result[i] = rst.get(i);
        }

        return result;
    }

    public void dfs(char[] array,boolean[] visited,StringBuilder temp) {
        if(temp.length() == array.length ) {
            rst.add(temp.toString());
            return;
        }
        for(int i = 0;i<array.length;i++){
            if(i >0 && array[i] == array[i-1] && !visited[i-1]){
                continue;
            }
            if(!visited[i]) {
                visited[i] = true;
                temp.append(array[i]);
                dfs(array,visited,temp);
                visited[i] = false;
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }


    public static void main(String[] args) {
        backTracking38 obj = new backTracking38();
        String[] abcs = obj.permutation("abc");
        System.out.println(Arrays.toString(abcs));
    }
}

