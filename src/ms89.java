import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ms89 {

    public List<Integer> grayCode(int n ){
        List<Integer> gray = new ArrayList<>();
        gray.add(0);
        for(int i =0;i<n;i++){
            int add = 1<<i;
            for(int j  = gray.size()-1;j>=0;j--){
                gray.add(gray.get(j)+add);
            }
        }
        return gray;
    }

    public static void main(String[] args) {
        ms89 obj = new ms89();
        List<Integer> integers = obj.grayCode(3);
        System.out.println(integers.toString());
    }
}
