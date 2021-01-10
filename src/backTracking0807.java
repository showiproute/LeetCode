import java.util.ArrayList;
import java.util.Arrays;

public class backTracking0807 {

    char[] array;
    ArrayList<String> store = new ArrayList<>();

    public String[] permutation(String S) {
        if(S == null || S.length() == 0){
            return null;
        }

        array = S.toCharArray();
        dfs(0);

        String[] result = new String[store.size()];
        for(int i =0;i<store.size();i++){
            result[i] = store.get(i);
        }

        return result;
    }

    public void dfs(int index){
        if(index == array.length-1){
            store.add(String.valueOf(array));
        }
        for(int i =index;i<array.length;i++){
            swap(i,index);
            dfs(index+1);
            swap(i,index);
        }
    }

    public void swap(int i,int index) {
        char temp = array[i];
        array[i] = array[index];
        array[index] = temp;
    }

    public static void main(String[] args) {
        backTracking0807 obj = new backTracking0807();
        String[] qwes = obj.permutation("qwe");
        System.out.println(Arrays.toString(qwes));
    }
}
