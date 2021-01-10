import java.util.ArrayList;
import java.util.Arrays;

public class string6 {

//    public String convert(String s, int numRows) {
//        if(numRows == 1) return s;
//        int length = s.length();
//        String[][] arr = new String[numRows][length];
//        int rows = 0;
//        int cols = 0;
//        for(int i = 0 ;i<length;){
//            if(rows == 0) {
//                for(int j = rows;j<numRows-1;j++){
//                    if(i >= length) break;
//                    String val = s.charAt(i)+"";
//                    arr[rows][cols] = val;
//                    i++;
//                    rows=(rows+1) % numRows;
//                }
//            }else{
//                for(int j = rows;j>0;j--){
//                    if(i >= length) break;
//                    String val = s.charAt(i)+"";
//                    arr[j][cols] = val;
//                    i++;
//                    cols++;
//                    rows = (rows-1) % numRows;
//                }
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0;i<arr.length;i++){
//            for(int j =0 ;j<arr[0].length;j++){
//                if(arr[i][j] != null) {
//                    sb.append(arr[i][j]);
//                }
//            }
//        }
//
//        return sb.toString();
//    }

    //flag = -1 巧妙用法
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        ArrayList<StringBuilder> list = new ArrayList<>();
        for(int i =0 ;i<numRows;i++){
            list.add(new StringBuilder());
        }
        int flag = -1;
        int rows = 0;
        for(int i= 0 ;i<s.length();i++){
            char val = s.charAt(i);
            list.get(rows).append(val);
            if(rows ==0 || rows == numRows -1) {
                flag = -flag;
            }
            rows+=flag;
        }
        StringBuilder rst = new StringBuilder();
        for(StringBuilder sb : list) {
            rst.append(sb.toString());
        }

        return rst.toString();
    }

    public static void main(String[] args) {
        string6 obj = new string6();
        String s = "LEETCODE";
        String convert = obj.convert(s, 3);
        System.out.println(convert);
    }

}
