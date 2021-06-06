import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class window1717 {


    public int[][] multiSearch(String big, String[] smalls) {
//        if(smalls == null || smalls.length ==0 ||
//                big == null || big.length() == 0) return new int[][]{};
        ArrayList<int[]> arrayList = new ArrayList<>();
        for(int i = 0;i<smalls.length;i++){
            if(smalls[i].length() == 0) {
                arrayList.add(new int[]{});
                continue;
            }
            int length = smalls[i].length();
            ArrayList<Integer> vals = windowsSearch(big, length, smalls[i]);
            if(vals.size() == 0) {
                arrayList.add(new int[]{});
            }else{
                int[] subArr = new int[vals.size()];
                for(int j = 0;j<vals.size();j++){
                    subArr[j] = vals.get(j);
                }
                arrayList.add(subArr);
            }
        }
        int[][] rst = new int[arrayList.size()][];
        for(int i = 0;i<arrayList.size();i++){
            rst[i] = arrayList.get(i);
        }

        return rst;
    }

    public ArrayList<Integer> windowsSearch(String big,int length,String sub) {
        ArrayList<Integer> rst = new ArrayList<>();
        for(int i = 0;i<big.length();i++) {
            if(i+length > big.length()) {
                break;
            }
            String substring = big.substring(i, i + length);
            if(substring.equals(sub)) {
                rst.add(i);
            }
        }

        return rst;
    }
//"abc"
//[""]
    public static void main(String[] args) {
        window1717 obj = new window1717();
        String big = "abc";
        String[] smalls = {""};
        int[][] ints = obj.multiSearch(big, smalls);
        for(int i = 0;i<ints.length;i++){
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}
