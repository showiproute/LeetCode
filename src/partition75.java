import java.util.*;

public class partition75 {

    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return ;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i =0 ;i<nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            }else{
                hashMap.put(nums[i],1);
            }
        }
//        System.out.println(hashMap.toString());
        ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey()-o2.getKey();
            }
        });
//        System.out.println(list.toString());
        int counts=0;
        for(Map.Entry<Integer,Integer> keyValue : list) {
            int key = keyValue.getKey();
            int value = keyValue.getValue();
            for(int i =0;i<value;i++){
                nums[counts] = key;
                counts++;
            }
        }
//        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        partition75 obj = new partition75();
        obj.sortColors(arr);

    }

}
