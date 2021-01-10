public class dict440 {

    //1. 计算某个数字前缀下有多少个子节点 <=N 的条件
    //2. 根据数量直接找到第k个节点
    public int findKthNumber(int n, int k) {
        int steps = 1;
        int prefix = 1;
        while (steps < k) {
            int counts = getCounts(n, prefix);
            if(counts+steps > k) {
                prefix*=10;
                steps++;
                System.out.println("prefix+step+counts"+prefix+" "+steps+" "+counts);
            }else{
                steps+=counts;
                prefix+=1;
            }
        }

        return prefix;
    }

    public int getCounts(int n,int prefix) {
        long next = prefix+1;
        long cur = prefix;
        int cnts = 0;
        while (cur <= n) {
            cnts += Math.min(n + 1, next) - cur;
            cur *= 10;
            next *= 10;
        }

        return cnts;
    }

    public static void main(String[] args) {
        dict440 obj = new dict440();
        int kthNumber = obj.findKthNumber(13, 7);
        System.out.println(kthNumber);
    }

}
