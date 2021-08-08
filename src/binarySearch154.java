public class binarySearch154 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
//            System.out.println("left"+left+"right"+right+"mid"+mid);
            if(nums[mid] < nums[right]) {
                right = mid;
            }else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }else if(nums[mid] == nums[right]) {
                 right = right-1;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
            /*
    输入: [4,5,6,7,0,1,2]
输出: 0
     */
        int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        binarySearch154 obj = new binarySearch154();
        int min = obj.findMin(arr);
        System.out.println(min);
    }

}
