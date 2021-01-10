import java.util.Arrays;
import java.util.Scanner;

public class tongcheng_1 {


    public int lineup (String peoples) {
        // write code here
        if(peoples == null || peoples.length() ==0) return 0;

        char[] charArray = peoples.toCharArray();
        char first = charArray[0];
        int counts = 0;

        for(int i =1;i<charArray.length;i++){
            if(charArray[i] == first) {
                continue;
            }
            if(i == charArray.length-1) {

                return counts;
            }

            for(int j = i +1; j<charArray.length; j++){
                if(charArray[j] == first) {
                    counts+=j- i;
                    swap(charArray, i,j);
                    break;
                }
            }

        }


        return counts;
    }

    public void swap(char[] array,int i ,int j ){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        tongcheng_1 obj = new tongcheng_1();
        int ggbbg = obj.lineup("GGBBG");
        System.out.println(ggbbg);
    }
}
