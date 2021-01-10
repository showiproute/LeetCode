import java.util.ArrayList;
import java.util.List;

public class dp118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rst = new ArrayList<>();
        if(numRows <=0 ) return rst;
        //状态转移方程 dp[i] = {1,dp[i-1]相加，1}
        //base
        List<Integer> first = new ArrayList<>();
        first.add(1);
        rst.add(first);

        for(int i = 1;i<numRows;i++){
            List<Integer> level =new ArrayList<>();
            level.add(1);
            List<Integer> up = rst.get(i - 1);
            for(int j = 0;j<up.size()-1;j++){
                level.add(up.get(j)+up.get(j+1));
            }
            level.add(1);
            rst.add(new ArrayList<>(level));
        }

        return rst;
    }

    public static void main(String[] args) {
        dp118 obj = new dp118();
        List<List<Integer>> generate = obj.generate(5);
        System.out.println(generate.toString());
    }
}
