import java.util.ArrayList;

public class string38 {

    ArrayList<String> arrayList = new ArrayList<>();
    public String countAndSay(int n) {
        if(n == 1) return "1";
        arrayList.add("1");
        arrayList.add("11");
        for(int i = 2;i<n;i++){
            String helper = helper(i);
            arrayList.add(helper);
        }

        return arrayList.get(arrayList.size()-1);
    }

    //3322251
    public String helper(int n) {
        String s = arrayList.get(n - 1);
        StringBuilder sb = new StringBuilder();
        char val = s.charAt(0);
        int counts = 1;
        for(int i = 1;i<s.length();i++){
            if(i == s.length()-1){
                if(s.charAt(i) == s.charAt(i-1)) {
                    sb.append(++counts).append(val);
                    break;
                }else{
                    sb.append(counts).append(val);
                    sb.append(1).append(s.charAt(i));
                    break;
                }
            }
            if(s.charAt(i) == val) {
                counts++;
            }else{
                sb.append(counts).append(val);
                counts=1;
                val=s.charAt(i);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        string38 obj = new string38();
        obj.arrayList = new ArrayList<>();
        String s = obj.countAndSay(5);
        System.out.println(s.toString());
    }


}
