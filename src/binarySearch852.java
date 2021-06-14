public class binarySearch852 {

    //输入：arr = [24,69,100,99,79,78,67,36,26,19]
    //输出：2
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length;
        int ans = 0;
        while (left <= right) {
            int mid = left+(right-left)/2;
            if(arr[mid] > arr[mid+1]) {
                ans = mid;
                right = mid-1;
            }else  {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {24,69,100,99,79,78,67,36,26,19};
        binarySearch852 obj = new binarySearch852();
        int i = obj.peakIndexInMountainArray(arr);
        System.out.println(i);
    }


}
