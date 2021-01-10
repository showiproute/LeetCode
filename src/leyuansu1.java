import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class leyuansu1 {
    public int[][] array;
    public HashSet<Integer> visited = new HashSet<>();
    public int[] ConfigValidator (int[][] input) {
        // write code here
        if(input == null || input.length == 0) return new int[]{};
        this.array = input;
        //init
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0;i<input.length;i++){
            for(int j = 0;j<input[i].length;j++){
                hashSet.add(input[i][j]);
            }
        }
//        System.out.println(hashSet.toString());
        visited.add(0);
        dfs(0);
//        System.out.println(visited.toString());

        int[] rst = new int[hashSet.size() - visited.size()];
        int counts = 0;
        for(Integer item : hashSet) {
            if(!visited.contains(item)){
                rst[counts] = item;
                counts++;
            }
        }

        return rst;
    }

    public void dfs(int index) {
        if(index < 0 || index >= array.length) return;
        for(int i = 0;i<array[index].length;i++){
//            System.out.println("index"+index+"i"+i);
            if(visited.contains(array[index][i])){
                continue;
            }
            visited.add(array[index][i]);
            dfs(array[index][i]);
        }
    }

    public static void main(String[] args) {
        int[][] input = {
                {1},
                {2},
                {1233},
                {434},
        };
        leyuansu1 obj = new leyuansu1();
        int[] ints = obj.ConfigValidator(input);
        System.out.println(Arrays.toString(ints));
    }
}
