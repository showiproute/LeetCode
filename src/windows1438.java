import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class windows1438 {

    //o(n^2)超时
//    public int longestSubarray(int[] nums, int limit) {
//        if(nums == null || nums.length == 0) return 0;
//        //输入：nums = [8,2,4,7], limit = 4
//        //输出：2
//        int size = 1;
//        for(int i = 0;i<nums.length;i++){
//            int minVal = nums[i];
//            int maxVal = nums[i];
//            for(int j = i+1;j<nums.length;j++){
//                minVal = Math.min(minVal,nums[j]);
//                maxVal = Math.max(maxVal,nums[j]);
//                if(Math.abs(minVal-maxVal) > limit) break;
//                size = Math.max(size,j-i+1);
//            }
//        }
//
//        return size;
//    }

    //o(nlogn)  红黑树的插入时间复杂度logn
//    public int longestSubarray(int[] nums, int limit) {
//        if(nums == null || nums.length == 0) return 0;
//        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
//        int left = 0;
//        int right = 0;
//        int size = 0;
//        while (left <= right && left < nums.length && right < nums.length) {
//            treeMap.put(nums[right],treeMap.getOrDefault(nums[right],0)+1);
//            if(treeMap.lastKey() - treeMap.firstKey() > limit) {
//                treeMap.put(nums[left],treeMap.get(nums[left])-1);
//                if(treeMap.get(nums[left]) == 0 ){
//                    treeMap.remove(nums[left]);
//                }
//                left++;
//            }
//            size = Math.max(size,right-left+1);
//            right++;
//        }
//
//        return size;
//    }


    //o(n) 双端队列
    public int longestSubarray(int[] nums, int limit) {
        if(nums == null || nums.length == 0) return 0;
        int left = 0,right = 0,size = 0;
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        while (left <= right && left < nums.length && right < nums.length) {
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            minDeque.offer(nums[right]);
            maxDeque.offer(nums[right]);
            while (!maxDeque.isEmpty() && !minDeque.isEmpty() && maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if(minDeque.peekFirst() == nums[left]) {
                    minDeque.pollFirst();
                }
                if(maxDeque.peekFirst() == nums[left]) {
                    maxDeque.pollFirst();
                }
                left++;
            }
            size = Math.max(size,right-left+1);
            right++;
        }

        return size;
    }


    public static void main(String[] args) {
        int[] nums = {10,1,2,4,7,2};
        windows1438 obj = new windows1438();
        int i = obj.longestSubarray(nums, 5);
        System.out.println(i);
    }


}
