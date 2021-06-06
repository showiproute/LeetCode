import java.util.Arrays;

public class array1720 {

/*
输入：encoded = [1,2,3], first = 1
输出：[1,0,2,1]
解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 */
    public int[] decode(int[] encoded, int first) {
        if(encoded == null || encoded.length == 0) return new int[]{};
        /*
        encoded[i-1] = arr[i-1] xor arr[i]
        arr[i-1] xor encoded[i-1] =  arr[i-1] xor arr[i-1] xor arr[i]
                                  = arr[i]
         */
        int[] arr = new int[encoded.length+1];
        arr[0] = first;
        for(int i = 1;i<arr.length;i++){
            arr[i] = arr[i-1] ^ encoded[i-1];
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] encoded = {1,2,3};
        int first = 1;
        array1720 obj = new array1720();
        int[] decode = obj.decode(encoded, first);
        System.out.println(Arrays.toString(decode));
    }
}
