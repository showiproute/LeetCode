import java.util.ArrayList;
import java.util.List;

public class digit1018 {

    //输入：[0,1,1]
    //输出：[true,false,false]
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> rst = new ArrayList<>();
        if(A == null || A.length == 0) return rst;
        int prefix = 0;
        for(int i = 0;i<A.length;i++){
            prefix = ((prefix<<1) + A[i])%5;
            rst.add(prefix == 0);
        }

        return rst;
    }

    public static void main(String[] args) {
        digit1018 obj = new digit1018();
        int[]A = {0,1,1};
        List<Boolean> booleans = obj.prefixesDivBy5(A);
        System.out.println(booleans.toString());
    }



}
//[false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,true,true,true,true,false]