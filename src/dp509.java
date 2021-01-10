import java.util.HashMap;

public class dp509 {

    public HashMap<Integer,Integer> hashMap = new HashMap<>();
    public int fib(int N) {
        if(N == 0 ) return 0;
        if(N == 1) return 1;
        if(hashMap.containsKey(N)){
            return hashMap.get(N);
        }
        int value = fib(N - 1) + fib(N - 2);
        hashMap.put(N,value);

        return hashMap.get(N);
    }

    public static void main(String[] args) {
        dp509 obj = new dp509();
        int fib = obj.fib(10);
        System.out.println(fib);
    }
}
