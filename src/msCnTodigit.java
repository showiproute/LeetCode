import java.util.HashMap;

public class msCnTodigit {

    //中文字符串转成数字 比如输入 二亿五千四百零三万六千七百零九 输出
    HashMap<String,Integer> zhToDigitMap = new HashMap<>();
    public long translateZh2Digit(String hans) {
        init();
        hans = hans.replace("零","");

        int yIndex = hans.indexOf("亿");
        int wIndex = hans.lastIndexOf("万");
        wIndex = wIndex < yIndex ? -1 : wIndex;

        long rst = 0;
        if(yIndex !=-1 && wIndex != -1) {
            System.out.println("first"+hans.substring(0,yIndex));
            System.out.println("second"+hans.substring(yIndex+1,wIndex));
            System.out.println("third"+hans.substring(wIndex+1));
            rst = process(hans.substring(0,yIndex))*100000000+process(hans.substring(yIndex+1,wIndex))*10000+
                    process(hans.substring(wIndex+1));
        } else if(wIndex != -1) {
            rst = process(hans.substring(0,wIndex))*10000+process(hans.substring(wIndex+1));
        }else if(yIndex != -1) {
            rst = process(hans.substring(0,yIndex))*100000000+process(hans.substring(yIndex+1));
        }

        return rst;
    }

    public long process(String hans) {
        //二万 五千 四百 九十 六/亿/
        // 五千四百零三/万/
        // 六千七百零九
        int wIndex = hans.indexOf("万");
        int qIndex = hans.indexOf("千");
        int bIndex = hans.indexOf("百");
        int sIndex = hans.indexOf("十");
        long rst = 0;
        if(wIndex != -1) {
            rst +=zhToDigitMap.get(hans.charAt(wIndex-1)+"")*10000;
        }
        if(qIndex != -1) {
            rst +=zhToDigitMap.get(hans.charAt(qIndex-1)+"")*1000;
        }
        if(bIndex != -1) {
            rst += zhToDigitMap.get(hans.charAt(bIndex-1)+"")*100;
        }
        if(sIndex != -1) {
            rst+=zhToDigitMap.get(hans.charAt(sIndex-1)+"")*10;
        }
        if(zhToDigitMap.containsKey(hans.charAt(hans.length()-1)+"")){
            rst+=zhToDigitMap.get(hans.charAt(hans.length()-1)+"");
        }

        return rst;
    }

    public void init(){
        zhToDigitMap.put("一",1);
        zhToDigitMap.put("二",2);
        zhToDigitMap.put("三",3);
        zhToDigitMap.put("四",4);
        zhToDigitMap.put("五",5);
        zhToDigitMap.put("六",6);
        zhToDigitMap.put("七",7);
        zhToDigitMap.put("八",8);
        zhToDigitMap.put("九",9);
    }

    public static void main(String[] args) {
        String inputStr = "一亿一千一百零一万一千一百零一";
        msCnTodigit obj = new msCnTodigit();
        long i = obj.translateZh2Digit(inputStr);
        System.out.println(i);
    }
}
