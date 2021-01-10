public class greedy860 {

    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) return true;
        int five = 0;
        int ten = 0;
        for(int i = 0;i<bills.length;i++){
            if(bills[i] == 5) {
                five++;
            }
            if(bills[i] == 10) {
                if(five >= 1) {
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }
            if(bills[i] == 20) {
                //case 1
                if(ten>=1 && five>=1) {
                    five--;
                    ten--;
                }else if(five>=3) {
                    five-=3;
                }else{
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //5,5,5,10,20]
        int[] nums = {5,5,10,10,20};
        greedy860 obj = new greedy860();
        boolean b = obj.lemonadeChange(nums);
        System.out.println(b);
    }

}

