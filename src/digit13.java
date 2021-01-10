import java.util.HashMap;

public class digit13 {

    HashMap<String,Integer> transMap = new HashMap<>();
    public int romanToInt(String s) {
        init();
        int counts = 0;
        for(int i = 0;i<s.length();i++){
            //处理6种情况
            if(s.charAt(i) == 'I') {
                if(i+1<s.length()) {
                    if(s.charAt(i+1) == 'V' || s.charAt(i+1) =='X'){
                        String key = "I" + s.charAt(i + 1);
                        counts+=transMap.get(key);
                        i++;
                        continue;
                    }
                }
                counts+=transMap.get("I");
            }else if(s.charAt(i) == 'C') {
                if(i+1 < s.length()) {
                    if(s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M') {
                        String key = "C" + s.charAt(i + 1);
                        counts+=transMap.get(key);
                        i++;
                        continue;
                    }
                }
                counts+=transMap.get("C");
            }else if(s.charAt(i) == 'X') {
                if(i+1 < s.length()) {
                    if(s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C') {
                        String key = "X" + s.charAt(i+1);
                        counts+=transMap.get(key);
                        i++;
                        continue;
                    }
                }
                counts+=transMap.get("X");
            }else{
                counts+=transMap.get(s.charAt(i)+"");
            }
        }

        return counts;
    }

    public void init() {
        transMap.put("I",1);
        transMap.put("V",5);
        transMap.put("X",10);
        transMap.put("L",50);
        transMap.put("C",100);
        transMap.put("D",500);
        transMap.put("M",1000);
        transMap.put("IV",4);
        transMap.put("IX",9);
        transMap.put("CD",400);
        transMap.put("CM",900);
        transMap.put("XL",40);
        transMap.put("XC",90);
    }

    public static void main(String[] args) {
        digit13 obj = new digit13();
        System.out.println(obj.romanToInt("MCMXCIV"));
    }

}
