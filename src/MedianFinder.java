import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    //solution1 : binaryInsert O(logN)
//    ArrayList<Integer> list;
//    int size;
//    /** initialize your data structure here. */
//    public MedianFinder() {
//        this.list = new ArrayList<>();
//        this.size = 0;
//    }
//
//    public void addNum(int num) {
//        binaryInsert(num);
//    }
//
//    public double findMedian() {
//        if(this.size % 2 != 0) {
//            return (double)list.get(this.size/2);
//        }else{
//            return (list.get(this.size/2-1) + (double)(list.get(this.size/2))) / 2.0;
//        }
//    }
//
//    public void binaryInsert(int num) {
//        int left = 0;
//        int right = list.size()-1;
//        while (left <= right) {
//            int mid = left+(right-left) / 2;
//            if(list.get(mid) > num) {
//                right = mid - 1;
//            }else {
//                left = mid + 1;
//            }
//        }
//
//        //move to right 1 positon
//        int size = list.size();
//        list.add(0);
//        for(int i = size-1;i>=left;i--){
//            list.set(i+1,list.get(i));
//        }
//        list.set(left,num);
//        this.size++;
//    }


    //大根堆 小根堆实现
    PriorityQueue<Integer> minHeap; //小根堆 存较大的一部分
    PriorityQueue<Integer> maxHeap; //大根堆 存较小的一部分
    /** initialize your data structure here. */
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        this.maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
    }

    public void addNum(int num) {
        if(minHeap.size() == maxHeap.size()) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }else{
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        int minSize = minHeap.size();
        int maxsize = maxHeap.size();
        if((minSize+maxsize) % 2 != 0) {
            return minHeap.isEmpty() ? 0.0 : (double)minHeap.peek();
        }else{
            return (minHeap.peek() + maxHeap.peek()) /2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);

    }
}
