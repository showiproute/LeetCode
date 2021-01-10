import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class backTracking17 {

    List<String> rst = new ArrayList<>();
    HashMap<Character,String> hashMap = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() ==0 ) return rst;
        //init
        hashMap.put('2',"abc");
        hashMap.put('3',"def");
        hashMap.put('4',"ghi");
        hashMap.put('5',"jkl");
        hashMap.put('6',"mno");
        hashMap.put('7',"pqrs");
        hashMap.put('8',"tuv");
        hashMap.put('9',"wxyz");

        backTracking(digits,new StringBuilder(),0);
        return rst;
    }

    public void backTracking(String digits,StringBuilder temp,int index) {
        if(temp.length() == digits.length()){
            rst.add(temp.toString());
            return;
        }

        String chList = hashMap.get(digits.charAt(index));
        for(int i = 0;i<chList.length();i++) {
            temp.append(chList.charAt(i));
            backTracking(digits,temp,index+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public static void main(String[] args) {
        backTracking17 obj = new backTracking17();
        List<String> strings = obj.letterCombinations("234");
        System.out.println(strings.toString());

    }

}
