public class sort1629 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char rst = keysPressed.charAt(0);
        int maxValue = releaseTimes[0];
        for(int i = 1;i<releaseTimes.length;i++){
            if(releaseTimes[i] - releaseTimes[i-1] > maxValue) {
                maxValue = releaseTimes[i]-releaseTimes[i-1];
                rst = keysPressed.charAt(i);
            }else if(releaseTimes[i] - releaseTimes[i-1] == maxValue) {
                if(keysPressed.charAt(i) > rst) {
                    rst = keysPressed.charAt(i);
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] arr = {12,23,36,46,62};
        sort1629 obj = new sort1629();
        char cbcd = obj.slowestKey(arr, "spuda");
        System.out.println(cbcd);
    }
}
