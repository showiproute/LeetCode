public class binarySearch {

    //normal
    public int binarySearch_normal(int[] array,int target){
        int left = 0;
        int right= array.length-1;
        while(left<=right) {
            int mid = left+(right-left) /2;
            if(array[mid] > target) {
                right = mid-1;
            }else if (array[mid] < target) {
                left = mid+1;
            }else{
                return mid;
            }
        }

        return -1;
    }

    //left 搜索左侧边界
    public int binarySearch_left(int[] array,int target) {
        int left = 0;
        int right = array.length-1;
        while(left<=right) {
            int mid = left+(right-left)/2;
            if(array[mid] < target) {
                left = mid+1;
            }else if(array[mid] > target) {
                right = mid-1;
            }else {
                right = mid-1;
            }
        }

        if(left >= array.length || array[left] != target) {
            return -1;
        }

        return left;
    }

    public int binarySearch_right(int[] array,int target) {
        int left = 0;
        int right = array.length-1;
        while(left <= right){
            int mid = left+(right-left) /2;
            if(array[mid] < target) {
                left = mid+1;
            }else if(array[mid] > target) {
                right = mid-1;
            }else{
                left = mid +1;
            }
        }

        if(right < 0 || array[right] != target) {
            return -1;
        }

        return right;
    }
}
