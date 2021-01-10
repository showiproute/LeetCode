public class dp46 {

    public int translateNum(int num) {
        String origin = num + "";
        char[] array = origin.toCharArray();
        if (array.length == 0) return 0;
        if (array.length == 1) return 1;

        int[] dp = new int[array.length];
        dp[0] = 1;
        int temp = Integer.parseInt(array[0]+""+array[1]);
        if(temp>=10 && temp<=25) {
            dp[1] = 2;
        }else{
            dp[1]= 1;
        }
        for (int i = 2; i < array.length; i++) {
            temp = Integer.parseInt(array[i - 1] + "" + array[i]);
            if (temp >= 10 && temp <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[array.length-1];
    }

    public static void main(String[] args) {
        dp46 obj = new dp46();
        int i = obj.translateNum(12258);
        System.out.println(i);
    }

}
