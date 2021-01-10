import java.util.Arrays;
import java.util.Random;

public class normalSort {

    //bubble sort
    public static void bubbleSort(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<nums.length-1-i;j++){
                if(nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }



    //select sort
    public static void selectSort(int[] nums) {
        for(int i =0;i<nums.length;i++){
            int minIndex = i;
            for(int j = i+1;j<nums.length;j++){
                if(nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }

        System.out.println(Arrays.toString(nums));
    }

    //insert sort
    public static void insertSort(int[] nums) {
        for(int i = 1;i<nums.length;i++){
            for(int j =i;j>0;j--){
                if(nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    //shell sort
    public static void shellSort(int[] nums) {
        for(int i = nums.length/2;i>0;i = i/2){
            for(int j = i;j<nums.length;j++){
                for(int k = j;k-i>=0;k=k-i){
                    if(nums[k] < nums[k-i]) {
                        int temp = nums[k-i];
                        nums[k-i] = nums[k];
                        nums[k] = temp;
                    }
                }
            }
        }


        System.out.println(Arrays.toString(nums));
    }

    //quickSort
    public static void quickSort(int[] nums,int low,int high) {
        if(low < high) {
            int pivot = partition(low,high,nums);
            quickSort(nums,low,pivot-1);
            quickSort(nums,pivot+1,high);
        }
    }

    public static int partition(int low,int high,int[] nums) {
        int pivot = nums[low];
        while(low < high) {
            while(low < high && nums[high] > pivot) {
                high--;
            }
            nums[low] = nums[high];

            while(low < high && nums[low] < pivot) {
                low++;
            }
            nums[high] = nums[low];
        }

        nums[low] = pivot;
        return low;
    }


    //mergeSort
    public static void mergeSort(int[] arr,int left,int right,int[] temp) {
        if(left < right) {
            int mid = (left+right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
        int i = left;
        int j = mid+1;
        int t = 0;
        while(i<=mid && j<=right) {
            if(arr[i]<arr[j]){
                temp[t++] = arr[i++];
            }else{
                temp[t++] = arr[j++];
            }
        }

        while(i<=mid) {
            temp[t++] = arr[i++];
        }
        while(j<=right) {
            temp[t++] = arr[j++];
        }

        t = 0;
        while(left<=right){
            arr[left++] = temp[t++];
        }
    }

    //heapSort
    public static void heapSort(int[] nums) {
        //构建大根堆
        for(int i = nums.length/2-1;i>=0;i--){
            adjust(nums,i,nums.length);
        }

        //调整堆的结构
        for(int i = nums.length-1;i>0;i--){
            swap(nums,0,i);
            adjust(nums,0,i);
        }

    }

    public static void adjust(int[] nums,int i,int length) {
        int temp = nums[i];
        for(int k = 2*i+1;k<length;k=2*k+1){
            if(k+1 < length && nums[k+1] > nums[k]) {
                k++;
            }
            if(nums[k] > temp) {
                nums[i] = nums[k];
                i = k ;
            }else{
                break;
            }
        }
        nums[i] = temp;
    }

    public static void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {7,6,7,11,5,12,3,0,1};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
