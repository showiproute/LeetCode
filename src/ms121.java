public class ms121 {
    //7,1,5,3,6,4
    public int maxProfit(int[] profit) {
        if(profit == null || profit.length == 0) {
            return 0;
        }
        int minValue = profit[0];
        int maxProfit = Integer.MIN_VALUE;
        for(int i =0;i<profit.length;i++ ){
            minValue = Math.min(minValue,profit[i]);
            maxProfit = Math.max(maxProfit,profit[i]-minValue);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] profit = {7,6,5,4,3,10};
        ms121 obj = new ms121();
        int i = obj.maxProfit(profit);
        System.out.println(i);
    }
}
