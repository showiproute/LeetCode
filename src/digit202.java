import java.util.HashSet;

public class digit202 {

    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while(n!=1 && !seen.contains(n)){
            seen.add(n);
            n = nextNum(n);
        }

        return n == 1;
    }

    public int nextNum(int n ){
        int totalSum = 0;
        while(n!=0) {
            totalSum += Math.pow(n % 10,2);
            n = n/10;
        }

        return totalSum;
    }

    public static void main(String[] args) {
        digit202 obj = new digit202();
        boolean happy = obj.isHappy(2);
        System.out.println(happy);
    }


}
