import java.util.HashMap;

public class thoughtsworks1 {

    public int countGoodRectangles(int[][] rectangles) {
        if(rectangles == null || rectangles.length == 0) return 0;
        int maxVal = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0;i<rectangles.length;i++){
            int val =  Math.min(rectangles[i][0],rectangles[i][1]);
            maxVal = Math.max(maxVal,val);
            hashMap.put(val,hashMap.getOrDefault(val,0)+1);
        }

        return hashMap.get(maxVal);
    }
    //输入：rectangles = [[5,8],[3,9],[5,12],[16,5]]
    //输出：3
    public static void main(String[] args) {
        int[][] arr = {
                {5,8},
                {3,9},
                {5,12},
                {16,5}
        };
        thoughtsworks1 obj = new thoughtsworks1();
        int i = obj.countGoodRectangles(arr);
        System.out.println(i);
    }


}
