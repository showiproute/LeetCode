public class leetcode121 {

    //7,1,5,3,6,4
    public int maxProfit(int[] profit) {
        if(profit == null  || profit.length ==0){
            return 0;
        }

        int minValue = profit[0];
        int maxPro = Integer.MIN_VALUE;

        for(int i = 0;i<profit.length;i++){
            if(profit[i] < minValue) {
                minValue = profit[i];
            }
            if(profit[i] - minValue > maxPro) {
                maxPro = profit[i] - minValue;
            }
        }

        return maxPro;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,3,2,1};
        leetcode121 obj = new leetcode121();
        int i = obj.maxProfit(array);
        System.out.println(i);

    }
}
