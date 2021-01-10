import java.util.ArrayList;

public class yuewen02 {

    public int countBit (int n) {
        // write code here
        int counts = 0;
        while(n!=0){
            if(n%2==1){
                counts++;
            }
            n = n/2;
        }

        return counts;
    }

    public static void main(String[] args) {
        yuewen02 obj = new yuewen02();
        int i = obj.countBit(8);
        System.out.println(i);
    }
}
