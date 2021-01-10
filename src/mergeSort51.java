public class mergeSort51 {
// [7,5,6,4]
    //暴力破解 O(n^2)
//    public int reversePairs(int[] nums) {
//        if(nums == null || nums.length ==0) return 0;
//        int counts = 0;
//        for(int i = 0;i<nums.length;i++){
//            for(int j =i+1;j<nums.length;j++){
//                if(nums[i] > nums[j]) {
//                    counts++;
//                }
//            }
//        }
//
//        return counts;
//    }

//    public int parCnts = 0;
//    public int reversePairs(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//
//        mergeSort(nums,0,nums.length-1,new int[nums.length]);
//
//        return parCnts;
//    }
//
//    public void mergeSort(int[] nums,int left,int right,int[] temp){
//        if(left < right) {
//            int mid = (left+right)/2;
//            mergeSort(nums,left,mid,temp);
//            mergeSort(nums,mid+1,right,temp);
//            merge(nums,left,mid,right,temp);
//        }
//    }
//
//    public void merge(int[] nums,int left,int mid,int right,int[] temp) {
//        int i = left;
//        int j = mid+1;
//        int k = 0;
//
//        while(i <= mid && j <= right) {
//            if(nums[j] < nums[i]) {
//                temp[k++] = nums[j++];
//                parCnts += mid-i+1;
//            }else{
//                temp[k++] = nums[i++];
//            }
//        }
//
//        while(i<=mid) {
//            temp[k++] = nums[i++];
//        }
//
//        while(j<=right) {
//            temp[k++] = nums[j++];
//        }
//
//        k = 0;
//        while(left<=right) {
//            nums[left++] = temp[k++];
//        }
//    }


    public int reversePairs(int[] nums) {
        if(nums == null || nums.length ==0 ) return 0;
        merge(nums,0,nums.length-1,new int[nums.length]);
        return parCnts;
    }

    public void merge(int[] nums,int left,int right,int[] temp) {
        if(left < right) {
            int mid = (left+right)/2;
            merge(nums,left,mid,temp);
            merge(nums,mid+1,right,temp);
            sort(nums,left,mid,right,temp);
        }
    }

    int parCnts = 0;
    public void sort(int[] nums,int left,int mid,int right,int[] temp) {
        int i = left;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= right) {
            if(nums[j] < nums[i]) {
                temp[k++] = nums[j++];
                parCnts+=mid-i+1;
            }else{
                temp[k++] = nums[i++];
            }
        }

        while(i < left) {
            temp[k++] = nums[i++];
        }
        while(j < right) {
            temp[k++] = nums[j++];
        }

        k = 0;
        while(left <= right) {
            nums[left++] = temp[k++];
        }
    }


    public static void main(String[] args) {
        mergeSort51 obj = new mergeSort51();
        int[] nums = {7,5,6,4};
        int i = obj.reversePairs(nums);
        System.out.println(i);
    }
}
