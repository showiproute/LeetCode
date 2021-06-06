import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class digit989 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> rst = new ArrayList<>();
        if(A == null || A.length == 0) {
            rst.add(K);
            return rst;
        }

        int lengthA= A.length-1;
        String strK = K+"";
        int lengthK = strK.length()-1;
        int carry = 0;
        while (lengthA >=0 && lengthK >= 0){
            int a = A[lengthA];
            int k = Integer.parseInt(strK.charAt(lengthK)+"");
            lengthA--;
            lengthK--;
            int val = (carry + a + k) % 10;
            carry = (carry+a+k) / 10;
            rst.add(val);
        }

        while (lengthA >=0 ){
            int a = A[lengthA];
            lengthA--;
            int val = (carry+a) % 10;
            carry = (carry+a)/10;
            rst.add(val);
        }

        while (lengthK >=0 ){
            int k = Integer.parseInt(strK.charAt(lengthK)+"");
            lengthK--;
            int val = (carry+k) % 10;
            carry = (carry+k) / 10;
            rst.add(val);
        }

        if(carry != 0){
            rst.add(carry);
        }
        Collections.reverse(rst);
        return rst;
    }

    //[1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3]
    //516
    public static void main(String[] args) {
        digit989 obj = new digit989();
        int[] nums = {2,7,4};
        List<Integer> integers = obj.addToArrayForm(nums, 181);
        System.out.println(integers);

    }



}
