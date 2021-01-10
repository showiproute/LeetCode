import java.util.HashMap;

public class factorial509 {

    HashMap<Integer,Integer> hashMap = new HashMap<>();
    public int fib(int N) {
        if(N == 0) return 0;
        if(N == 1 || N == 2) return 1;
        if(hashMap.containsKey(N)) {
            return hashMap.get(N);
        }
        int val = fib(N-1) + fib(N-2);
        hashMap.put(N,val);
        return val;
    }

    public static void main(String[] args) {
        factorial509 obj = new factorial509();
        int fib = obj.fib(10);
        System.out.println(fib);
    }
}
