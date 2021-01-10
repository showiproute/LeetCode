import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class windows239 {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if(nums == null || nums.length == 0 || nums.length < k) return new int[]{};
//        int[] ret = new int[nums.length-k+1];
//        for(int i = 0;i<=nums.length-k;i++){
//            int maxValue = Integer.MIN_VALUE;
//            for(int j = i;j<i+k;j++){
//                maxValue = Math.max(maxValue,nums[j]);
//            }
//            ret[i] = maxValue;
//        }
//
//        return ret;
//    }
    // o(n^2) 超时

    //双端队列实现
//    ArrayDeque<Integer> deque = new ArrayDeque<>();
//    int[] array;
//
//    public void push(int x) {
//        while(!deque.isEmpty() && deque.getLast() < x) {
//            deque.removeLast();
//        }
//        deque.addLast(x);
//    }
//
//    public void pop(int x) {
//        if(!deque.isEmpty() && deque.getFirst() == x) {
//            deque.removeFirst();
//        }
//    }
//
//    public int max(){
//        return deque.getFirst();
//    }
//
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if(nums == null || nums.length < k) return new int[]{};
//        int[] output = new int[nums.length-k+1];
//        int counts = 0;
//        this.array = nums;
//        for(int i = 0;i<nums.length;i++){
//            if(i < k-1) {
//                push(nums[i]);
//            }else{
//                push(nums[i]);
//                output[counts] = max();
//                pop(nums[i-k+1]);
//                counts++;
//            }
//        }
//
//        return output;
//    }

    //优先级队列（大根堆来实现）
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1) return nums;
        int length = nums.length;
        int[] rst = new int[length-k+1];
        //nums,index
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }else{
                    return o2[0] - o1[0];
                }
            }
        });

        for(int i = 0;i<k;i++){
            priorityQueue.offer(new int[]{nums[i],i});
        }
        rst[0] = priorityQueue.peek()[0];
        //输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
        //输出：[3,3,5,5,6,7]
        int cnts = 1;
        for(int i = k;i<length;i++){
            while(priorityQueue.peek()[1] <= i -k){
                priorityQueue.poll();
            }
            priorityQueue.offer(new int[]{nums[i], i});
            rst[cnts] = priorityQueue.peek()[0];
            cnts++;
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {1,-1};
        windows239 obj = new windows239();
        int[] ints = obj.maxSlidingWindow(nums, 1);
        System.out.println(Arrays.toString(ints));

//        ArrayDeque<Integer> de = new ArrayDeque<>();
//        de.add(1);
//        de.add(2);
//        System.out.println(de.getLast());
    }



}
