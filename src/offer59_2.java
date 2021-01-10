import java.util.Arrays;

public class offer59_2 {

    int[] q = new int[2000];
    int begin = 0;
    int end = 0;
    int maxValue = -1;
    public offer59_2(){

    }

    public int max_value(){
        if(begin == end) {
            return -1;
        }

        return maxValue;
    }

    public void push_back(int value) {
        q[end++] = value;
        maxValue = Math.max(maxValue,value);
    }

    public int pop_front(){
        if(begin == end) {
            return -1;
        }

        int value = q[begin];
        if(value == maxValue) {
            maxValue = q[begin+1];
            for(int i = begin+1;i<=end;i++){
                maxValue = Math.max(maxValue,q[i]);
            }
        }

        begin++;
        return value;
    }


    public static void main(String[] args) {
        offer59_2 obj = new offer59_2();
        obj.push_back(1);
        obj.push_back(2);
        System.out.println(obj.max_value());
        System.out.println(obj.pop_front());
        System.out.println(obj.pop_front());
        System.out.println(obj.pop_front());
        System.out.println(obj.max_value());
    }
}
