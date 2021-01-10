import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class ms215 {

    //method1 quickSelect
    Random random = new Random();
    public int targetIndex = -1;
    public int findKthLargest(int[] nums, int k) {
        if(nums == null) return 0;
        int target = nums.length-k;
        quickSelect(nums,0,nums.length-1,target);

        return nums[targetIndex];
    }

    public void quickSelect(int[] nums,int left,int right,int target) {
        int index = randomPartition(nums, left, right);
        if(index<target){
            quickSelect(nums,index+1,right,target);
        }else if(index>target) {
            quickSelect(nums,left,index-1,target);
        }else{
            targetIndex = index;
        }
    }

    public int randomPartition(int[] nums,int left,int right) {
        int rand = left+random.nextInt(right-left+1);
        swap(nums,left,rand);

        int pivot = nums[left];
        int i = left+1;
        int j = right;

        while(true) {
            while(i<=j && nums[i] <= pivot){
                i++;
            }

            while(i<=j && nums[j] >= pivot) {
                j--;
            }

            if(i>j) break;

            swap(nums,i,j);
            i++;
            j--;
        }

        swap(nums,left,j);
        return j;
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //method heap 大根堆
    public int findKthLargest2(int[] nums, int k) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(nums.length,comparator);
        for(int i =0;i<nums.length;i++){
            priorityQueue.offer(nums[i]);
        }
        for(int i =0;i<k-1;i++){
            priorityQueue.poll();
        }

        return priorityQueue.peek();
    }


    public static void main(String[] args) {
        ms215 obj = new ms215();
        int[] array = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kthLargest = obj.findKthLargest(array, 4);
        System.out.println(kthLargest);
        int kthLargest2 = obj.findKthLargest2(array, 4);
        System.out.println(kthLargest2);
    }
}
