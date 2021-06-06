public class binarySearch1482 {

    public int minDays(int[] bloomDay, int m, int k) {
        if(m * k > bloomDay.length) return -1;
        int left = bloomDay[0];
        int right = 0;
        for(int i = 0;i<bloomDay.length;i++){
            right = Math.max(right,bloomDay[i]);
            left = Math.min(left,bloomDay[i]);
        }
        while (left <= right) {
            int mid = left+(right-left) / 2;
            if(cal(bloomDay,mid,m,k)) {
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return left;
    }

    public boolean cal(int[] bloomDay,int dis,int m,int k) {
        int cnts = 0;
        int flowers = 0;
        for(int i = 0;i<bloomDay.length && cnts < m;i++){
            if(bloomDay[i] <= dis) {
                flowers++;
                if(flowers == k) {
                    cnts++;
                    flowers=0;
                }
            }else{
                flowers = 0;
            }
        }

        return cnts >= m;
    }

    //输入：bloomDay = [1,10,2,9,3,8,4,7,5,6], m = 4, k = 2
    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        binarySearch1482 obj = new binarySearch1482();
        int i = obj.minDays(bloomDay, 2, 3);
        System.out.println(i);
    }
}
