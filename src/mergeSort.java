import java.util.Arrays;

public class mergeSort {

    public void sort(int[] arr,int left,int right,int[] temp) {
        if(left<right) {
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);
            sort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    public void merge(int[] arr,int left,int mid,int right,int[] temp) {
        int i = left;
        int j = mid+1;
        int k = 0;
        while(i<= mid && j<=right) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i];
                i++;
            }else{
                temp[k++] = arr[j];
                j++;
            }
        }

        while(i<=mid) {
            temp[k++] = arr[i];
            i++;
        }
        while(j<=right) {
            temp[k++] = arr[j];
            j++;
        }

        k = 0;
        while(left <= right) {
            arr[left++] = temp[k++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        int[] temp = new int[arr.length];
        mergeSort obj = new mergeSort();
        obj.sort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(temp));
    }
}
