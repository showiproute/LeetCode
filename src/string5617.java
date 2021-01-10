public class string5617 {
/*
请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。
Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，
"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。

 */
    public String interpret(String command) {
        if(command == null || command.length() ==0 ) return "";
        StringBuilder sb = new StringBuilder();
        for(int i =0 ;i<command.length();){
            char value = command.charAt(i);
            if(value == '(') {
                if(command.charAt(i+1) == ')'){
                    sb.append('o');
                    i+=2;
                }else{
                    sb.append("al");
                    i+=4;
                }
            }else if(value == 'G') {
                sb.append("G");
                i++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        string5617 obj = new string5617();
        String interpret = obj.interpret("(al)G(al)()()G");
        System.out.println(interpret);
    }
}