import java.util.Arrays;

public class arr493 {

    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        //case

        mergeSort(nums,0,nums.length-1,new int[nums.length]);
        return counts;
    }

    public int counts = 0;

    //mergeSort
    public void mergeSort(int[] nums,int i,int j,int[] temp) {
        if(i<j) {
            int mid = i+(j-i)/2;
            mergeSort(nums,i,mid,temp);
            mergeSort(nums,mid+1,j,temp);
            merge(nums,temp,i,mid,j);
        }
    }

    public void merge(int[] nums,int[] temp,int left,int mid,int right) {
        int i = left;
        int j = mid+1;
        int k = 0;

        while(i<=mid) {
            while(j<=right && (long)nums[i] > (long)nums[j]*2) {
                j++;
            }
            counts+=j-mid-1;
            i++;
        }
        i = left;
        j = mid+1;

        while(i<=mid && j<=right) {
            if(nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }

        while(i<=mid) {
            temp[k++] = nums[i++];
        }

        while(j<=right) {
            temp[k++] = nums[j++];
        }

        k =0 ;
        while(left <= right) {
            nums[left++] = temp[k++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,1,2};
        arr493 obj = new arr493();
        int i = obj.reversePairs(nums);
        System.out.println(i);
    }
}
