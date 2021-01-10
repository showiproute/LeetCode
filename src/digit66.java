import java.util.Arrays;

public class digit66 {

    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i] = digits[i]%10;
            if(digits[i] != 0) return digits;
        }

        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
    public static void main(String[] args) {
        digit66 obj = new digit66();
        int[] ints = obj.plusOne(new int[]{9,8,7,6,5,4,3,2,1,0});
        System.out.println(Arrays.toString(ints));
    }


}
