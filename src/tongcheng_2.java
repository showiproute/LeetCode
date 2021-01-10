import java.util.*;

public class tongcheng_2 {

    public int[] removeDuplicate (int[] array) {
        // write code here
        LinkedHashMap<Integer,Integer> hashSet = new LinkedHashMap<>();
        for(int i = 0;i<array.length;i++){
            if(hashSet.containsKey(array[i])) {
                hashSet.remove(array[i]);
                hashSet.put(array[i],1);
            }else{
                hashSet.put(array[i],1);
            }
        }
        System.out.println(hashSet.toString());
        int[] rst = new int[hashSet.size()];
        int counts = 0;
        for(Map.Entry<Integer,Integer> keyValue : hashSet.entrySet()) {
            rst[counts] = keyValue.getKey();
            counts++;
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,1};
        tongcheng_2 obj = new tongcheng_2();
        int[] ints = obj.removeDuplicate(arr);
        System.out.println(Arrays.toString(ints));
    }
}
