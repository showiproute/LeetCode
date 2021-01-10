import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class hash1207 {


    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i =0 ;i<arr.length;i++){
            hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0)+1);
        }
        Collection<Integer> values = hashMap.values();
        HashSet<Integer> hashSet = new HashSet<>();
        for(Integer value : values){
            hashSet.add(value);
        }
//        System.out.println(hashMap.toString());

        return hashSet.size() == values.size();
    }

    public static void main(String[] args) {
        hash1207 obj = new hash1207();
        int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
        boolean b = obj.uniqueOccurrences(arr);
        System.out.println(b);
    }
}
