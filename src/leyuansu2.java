import java.util.Arrays;

public class leyuansu2 {

    public int GetMaxGold (int count, int[] depth) {
        // write code here
        if(depth == null || depth.length ==0) return 0;
        int[] rst = new int[count];
        for(int i=0;i<depth.length;i++){
            int sum = 1;
            int prevValue = depth[i];
            for(int j =i+1;j<depth.length;j++){
                if(prevValue <= depth[j]){
                    sum++;
                    prevValue = depth[j];
                }
            }
            rst[i] = sum;
        }
        int minMaxValue = Integer.MIN_VALUE;
        for(int i = 0;i<rst.length;i++){
            minMaxValue = Math.max(minMaxValue,rst[i]);
        }
        System.out.println(Arrays.toString(rst));

        return minMaxValue;
    }

    public static void main(String[] args) {
        leyuansu2 obj = new leyuansu2();
        int[] depth = {15522,13267,7072,23658,4780,5093,954,21401,30560,5332};
        int i = obj.GetMaxGold(10, depth);
        System.out.println(i);
    }
    //5,[14,11,4,6,31]

}
