import java.util.Arrays;

public class windows1423 {

    //    //输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
    //    //输出：202
    public int maxScore(int[] cardPoints, int k) {
        if (k == 0 || cardPoints == null || cardPoints.length == 0) return 0;
        int winSize = cardPoints.length-k;
        int sum = 0;
        for(int i = 0;i<winSize;i++){
            sum+=cardPoints[i];
        }
        int minVal = sum;
        for(int i = winSize;i<cardPoints.length;i++){
            sum = sum+cardPoints[i]-cardPoints[i-winSize];
            minVal = Math.min(minVal,sum);
        }

        return Arrays.stream(cardPoints).sum()-minVal;
    }


    public static void main(String[] args) {
        int[] nums = {1,79,80,1,1,1,200,1};
        windows1423 obj = new windows1423();
        int i = obj.maxScore(nums, 3);
        System.out.println(i);
    }

}
