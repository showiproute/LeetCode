import java.util.Arrays;

public class string1736 {

    public String maximumTime(String time) {
        char[] array = time.toCharArray();
        if(array[0] == '?') {
            if((array[1] >= '0' && array[1] < '4')||array[1] == '?'){
                array[0] = '2';
            }else{
                array[0] = '1';
            }
        }
        if(array[1] == '?') {
            if(array[0] < '2') {
                array[1] = '9';
            }else{
                array[1] = '3';
            }
        }
        if(array[3] == '?') {
            array[3] = '5';
        }
        if(array[4] == '?') {
            array[4] = '9';
        }

        return String.valueOf(array);
    }

    public static void main(String[] args) {
        string1736 obj = new string1736();
        String s = obj.maximumTime("??:3?");
        System.out.println(s);

    }

}
