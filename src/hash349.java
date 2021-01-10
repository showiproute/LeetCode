import java.util.HashSet;

public class hash349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return new int[]{};
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0;i<nums1.length;i++){
            hashSet.add(nums1[i]);
        }

        HashSet<Integer> rst = new HashSet<>();
        for(int i= 0 ;i<nums2.length;i++){
            if(hashSet.contains(nums2[i])){
                rst.add(nums2[i]);
            }
        }

        int[] retArr = new int[rst.size()];
        int counts = 0;
        for(Integer item : rst) {
            retArr[counts] = item;
            counts++;
        }

        return retArr;
    }

}