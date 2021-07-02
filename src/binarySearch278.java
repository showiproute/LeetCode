public class binarySearch278 {

    public boolean isBadVersion(int n) {
        boolean[] test = new boolean[5];
        test[0] = false;
        test[1] = false;
        test[2] = false;
        test[3] = false;
        test[4] = true;
        return test[n];
    }
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if(!isBadVersion(mid)) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        binarySearch278 obj = new binarySearch278();
        int i = obj.firstBadVersion(5);
        System.out.println(i);
    }

}
