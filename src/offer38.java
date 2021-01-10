import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class offer38 {

    //回溯法
    char[] array;
    ArrayList<String> rst = new ArrayList<>();

    public String[] permutation(String s) {
        if (s == null || s.length() ==0){
            return null;
        }

        array = s.toCharArray();

        dfs(0);

        String[] output = new String[rst.size()];
        for(int i =0;i<rst.size();i++){
            output[i] = rst.get(i);
        }

        return output;
    }

    public void dfs(int index){
        if(index == array.length-1) {
            rst.add(String.valueOf(array));
            return;
        }

        HashSet<Character> hashSet = new HashSet<>();
        for(int i= index;i<array.length;i++){
            if(hashSet.contains(array[i])) continue;
            hashSet.add(array[i]);
            swap(i,index);
            dfs(index+1);
            swap(i,index);
        }
    }

    public void swap(int i,int index){
        char temp = array[i];
        array[i] = array[index];
        array[index] = temp;
    }


    public static void main(String[] args) {
        offer38 obj = new offer38();
        String inputStr= "aaaab";
        String[] permutation = obj.permutation(inputStr);
        System.out.println(Arrays.toString(permutation));
    }
}
