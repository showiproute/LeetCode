public class digit1689 {

    public int minPartitions(String n) {
        int maxVal =0;
        for(int i = 0;i<n.length();i++){
            int val = Integer.parseInt(n.charAt(i) + "");
            if(val > maxVal) {
                maxVal = val;
            }
        }

        return maxVal;
    }

    public static void main(String[] args) {
        digit1689 obj = new digit1689();
        int i = obj.minPartitions("27346209830709182346");
        System.out.println(i);
    }


}
