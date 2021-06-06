import java.util.Arrays;

public class digit1734 {

    /*
    encoded[i] = perm[i] xor perm[i+1]
    perm[i] xor encoded[i] = perm[i+1]
    perm[i-1] xor encode[i-1] = perm[i]



    encoded[i] = perm[i] xor perm[i+1]

    total = perm[0] xor perm[1] xor perm[22] .... perm[n]
    encode[1] xor encode[3] xor encode[5] .... encode[2n-1] = perm[1] xor perm[2] ... perm[n];

    perm[0] =  total xor encode
     */
    public int[] decode(int[] encoded) {
        int total = 0;
        for(int i = 1;i<=encoded.length+1;i++){
            total ^= i;
        }
        int odd = 0;
        for(int i = 1;i<encoded.length;i+=2){
            odd ^= encoded[i];
        }
        int first = total ^ odd;
        int[] perm = new int[encoded.length+1];
        perm[0] = first;
        for(int i = 1; i<perm.length;i++){
            perm[i] = perm[i-1] ^ encoded[i-1];
        }

        return perm;
    }

    public static void main(String[] args) {
        digit1734 obj = new digit1734();
        int[] encoded = {6,5,4,6};
        int[] decode = obj.decode(encoded);
        System.out.println(Arrays.toString(decode));
    }

}
