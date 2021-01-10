import java.util.ArrayList;
import java.util.List;

public class dp119 {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> rst = new ArrayList<>();
        //状态转移方程 dp[i] = {1,dp[i-1]相加，1}
        //base
        List<Integer> first = new ArrayList<>();
        first.add(1);
        rst.add(first);

        for(int i = 1;i<rowIndex+1;i++){
            List<Integer> level =new ArrayList<>();
            level.add(1);
            List<Integer> up = rst.get(i - 1);
            for(int j = 0;j<up.size()-1;j++){
                level.add(up.get(j)+up.get(j+1));
            }
            level.add(1);
            rst.add(new ArrayList<>(level));
        }

        return rst.get(rowIndex);
    }

    public static void main(String[] args) {
        dp119 obj = new dp119();
        List<Integer> row = obj.getRow(0);
        System.out.println(row.toString());

    }
}
