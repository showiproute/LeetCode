import java.util.*;

public class array845 {

    public class Dot {
        int val;
        int index;

        public Dot(int val,int index){
            this.val = val;
            this.index = index;
        }

    }

    public int longestMountain(int[] A) {
        if(A == null || A.length == 0) return 0;
        HashMap<Dot,Integer> hashMap = new HashMap<>();
        for(int i = 1;i<A.length-1;i++){
            Dot dot = new Dot(A[i],i);
            hashMap.put(dot,i);
        }
        ArrayList<Map.Entry<Dot,Integer>> arrayList = new ArrayList<>(hashMap.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<Dot, Integer>>() {
            @Override
            public int compare(Map.Entry<Dot, Integer> o1, Map.Entry<Dot, Integer> o2) {
                return o2.getKey().val - o1.getKey().val;
            }
        });
//        System.out.println(arrayList.toString());
        int maxValue = 0;
        for(Map.Entry<Dot,Integer> dot : arrayList) {
            Dot key = dot.getKey();
            int i = key.index;
            int j = key.index;
            while(i>0 && A[i] >A[i-1]){
                i--;
            }
            while(j<A.length-1 && A[j] >A[j+1]){
                j++;
            }
            if(i!= key.index && j!=key.index){
                maxValue = Math.max(maxValue,j-i+1);
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2};
        array845 obj = new array845();
        int i = obj.longestMountain(arr);
        System.out.println(i);
    }
}
