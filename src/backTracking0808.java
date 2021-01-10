import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class backTracking0808 {

    char[] array ;
    LinkedHashSet<String> hashSet = new LinkedHashSet<>();

    public String[] permutation(String S) {
        array = S.toCharArray();

        dfs(0);
        String[] result = new String[hashSet.size()];
        int counts = 0;
        for(String item:hashSet) {
            result[counts] = item;
            counts++;
        }

        return result;
    }

    public void dfs(int index){
        if(index == array.length-1) {
            hashSet.add(String.valueOf(array));
            return;
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
        backTracking0808 obj = new backTracking0808();
        String[] qqes = obj.permutation("abc");
        System.out.println(Arrays.toString(qqes));
    }
}
