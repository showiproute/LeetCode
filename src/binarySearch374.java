public class binarySearch374 {

    public int guess(int num) {
        int[] nums = {-1,-1,-1,-1,-1,-1,0,1,1,1,1};
        return nums[num];
    }


    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        while (left <= right ){
            int mid = left+(right-left) / 2;
            if(guess(mid) == 0) {
                return mid;
            }else if(guess(mid) < 0) {
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        binarySearch374 obj = new binarySearch374();
        int i = obj.guessNumber(10);
        System.out.println(i);

    }
}
