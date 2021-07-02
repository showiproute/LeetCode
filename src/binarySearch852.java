public class binarySearch852 {

    //输入：arr = [24,69,100,99,79,78,67,36,26,19]
    //输出：2
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length;
        while (left <= right) {
            int mid = left + (right-left) /2;
            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]) {
                return mid;
            }else if(mid == arr.length-1 || arr[mid] > arr[mid+1]) {
                right = mid - 1;
            }else if(mid == 0 || arr[mid] > arr[mid-1]) {
                left = mid + 1 ;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = {24,69,100,99,79,78,67,36,26,19};
        binarySearch852 obj = new binarySearch852();
        int i = obj.peakIndexInMountainArray(arr);
        System.out.println(i);
    }


}
