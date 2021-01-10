import java.util.HashMap;

public class offer10_2 {

    HashMap<Integer,Integer> map = new HashMap<>();
    public int numWays(int n) {
        if(n == 0) return 1;
        if(n ==1 ) return  1;
        if(n ==2 )return 2;

        if(map.containsKey(n)) {
            return map.get(n);
        }

        int ways= (numWays(n-1)+numWays(n-2)) % 1000000007;
        map.put(n,ways);
        return ways;
    }

    public static void main(String[] args) {
        offer10_2 obj = new offer10_2();
        int i = obj.numWays(44);
        System.out.println(i);
    }

}
