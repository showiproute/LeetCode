import java.util.*;

public class systemDesign41 {
    //基于binarySerach的查找算法 时间复杂度O(logN);
//    public static class MedianFinder {
//        /** initialize your data structure here. */
//        ArrayList<Double> list;
//        int size;
//        public MedianFinder() {
//            this.list = new ArrayList<>();
//            this.size = 0;
//        }
//
//        public void addNum(int num) {
//            size++;
//            binaryInsert(num,list);
//        }
//
//        public void binaryInsert(double num,ArrayList<Double> list ) {
//            int i =0 ;
//            int j = list.size()-1;
//            while(i<=j) {
//                int mid = (i+j)/2;
//                if(list.get(mid) > num) {
//                    j = mid-1;
//                }else if(list.get(mid) < num){
//                    i = mid+1;
//                }else{
//                    i = mid+1;
//                }
//            }
//            int size = list.size();
//            list.add((double) 0);
//            for(int k =size-1;k>=i;k--){
//                list.set(k+1,list.get(k));
//            }
//            list.set(i,num);
////            System.out.println(list.toString());
//        }
//
//        public double findMedian() {
//            if(size ==0 ) return 0.0;
//            if(size % 2 ==0) {
//                return (list.get(size/2-1)+list.get(size/2))/2;
//            }else{
//                return list.get(size/2);
//            }
//        }
//    }

    /*
    ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
[[],[1],[2],[],[3],[]]
输出：[null,null,null,1.50000,null,2.00000]
     */


    /** initialize your data structure here. */
    public static  class MedianFinder {
        PriorityQueue<Double> maxHeap;  //大根堆存储 数组中较小的元素
        PriorityQueue<Double> minHeap; //小根堆存储 数组中较大的元素
        public MedianFinder(){
            this.maxHeap = new PriorityQueue<>(new Comparator<Double>() {
                @Override
                public int compare(Double o1, Double o2) {
                    return (int) (o2-o1);
                }
            });
            this.minHeap = new PriorityQueue<>(new Comparator<Double>() {
                @Override
                public int compare(Double o1, Double o2) {
                    return (int) (o1-o2);
                }
            });
        }

        public void addNum(int num) {
            maxHeap.offer((double) num);

            minHeap.offer(maxHeap.poll());

            //balances
            if(minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            return maxHeap.size() == minHeap.size() ? (maxHeap.peek()+minHeap.peek())/2 :
                    maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(10);
        System.out.println(obj.findMedian());
        obj.addNum(6);
        System.out.println(obj.findMedian());
    }
}
