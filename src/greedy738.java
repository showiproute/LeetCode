public class greedy738 {

    public int monotoneIncreasingDigits(int N) {
        char[] array = (N + "").toCharArray();
        int length = array.length;
        int i = 1;
        for(;i<length;i++){
            if(array[i] < array[i-1]) {
                break;
            }
        }
        if(i<length) {
            while(i>0 && array[i] < array[i-1]) {
                array[i-1] -=1;
                i--;
            }
            i+=1;
            for(;i<length;i++){
                array[i] = '9';
            }
        }

        return Integer.parseInt(new String(array));
    }

    public static void main(String[] args) {
        greedy738 obj = new greedy738();
        System.out.println(obj.monotoneIncreasingDigits(332));
    }
}

