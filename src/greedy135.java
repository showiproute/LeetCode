import java.util.Arrays;

public class greedy135 {

    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int length = ratings.length;
        int[] left = new int[length];
        int[] right = new int[length];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for(int i = 0 ;i<length;i++){
            if(i>0 && ratings[i] > ratings[i-1]) {
                left[i] = left[i-1]+1;
            }
        }
        for(int i = length-1;i>=0;i--){
            if(i < length-1 && ratings[i] > ratings[i+1]) {
                right[i] = right[i+1]+1;
            }
        }
        int sum = 0;
        for(int i = 0;i<length;i++){
            sum+=Math.max(left[i],right[i]);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2};
        greedy135 obj = new greedy135();
        int candy = obj.candy(arr);
        System.out.println(candy);
    }

}
