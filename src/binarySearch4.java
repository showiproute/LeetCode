public class binarySearch4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return 0.0;
        if(nums1.length > nums2.length ) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        //分割线 左边的元素都小于右边的元素
        //划分分割线之后，左右两边数组元素的个数为 (m+n+1)/2
        int totalLeft = (m+n+1) /2;
        int left = 0;
        int right = m;
        //满足交叉性质：  nums1[i-1] <= nums2[j] && nums1[i] >= nums2[j-1]
        while(left < right) {
            int i = left+(right-left+1) / 2;
            int j = totalLeft-i;
            if(nums1[i-1] > nums2[j]) {
                right = i-1;
            }else{
                left = i;
            }
        }

        int nums1Left = left == 0 ? Integer.MIN_VALUE : nums1[left-1];
        int nums1Right = left == m ? Integer.MAX_VALUE : nums1[left];
        int nums2Left = totalLeft - left == 0 ? Integer.MIN_VALUE : nums2[totalLeft-left-1];
        int nums2Right = totalLeft- left == n ? Integer.MAX_VALUE : nums2[totalLeft-left];
    //test
//        System.out.println("nums1Left"+nums1Left);
//        System.out.println("nums1Right"+nums1Right);
//        System.out.println("nums2Left"+nums2Left);
//        System.out.println("nums2Right"+nums2Right);

        if((m+n) % 2 == 0) {
            int i = Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right);
            return (double) i /2;
        }else{
            return Math.max(nums1Left,nums2Left);
        }

    }

    public static void main(String[] args) {
        //1 2 3 | 6
        //1 3   |  4 5 9 10
        int[] nums1 = {1,2,3,6};
        int[] nums2 = {1,3,4,5,9};
        binarySearch4 obj = new binarySearch4();
        double medianSortedArrays = obj.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

}