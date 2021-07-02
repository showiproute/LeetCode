import java.util.Arrays;

public class greedy1833 {

    //输入：costs = [1,3,2,4,1], coins = 7
    //输出：4
    //解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int cnts = 0;
        for(int i =0 ;i<costs.length;i++){
            if(coins >= costs[i]) {
                coins-=costs[i];
                cnts++;
            }else{
                break;
            }
        }

        return cnts;
    }

    public static void main(String[] args) {
        int[] costs = {1,3,2,4,1};
        greedy1833 obj=  new greedy1833();
        int i = obj.maxIceCream(costs, 7);
        System.out.println(i);
    }
}
