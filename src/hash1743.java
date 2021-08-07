import java.util.*;

public class hash1743 {

    //输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
    //输出：[-2,4,1,-3]
    public int[] restoreArray(int[][] adjacentPairs) {
        if(adjacentPairs.length == 1) return adjacentPairs[0];
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for(int i = 0;i<adjacentPairs.length;i++){
            hashMap.putIfAbsent(adjacentPairs[i][0],new ArrayList<>());
            hashMap.putIfAbsent(adjacentPairs[i][1],new ArrayList<>());
            hashMap.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
            hashMap.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);
        }
        int[] rst = new int[adjacentPairs.length+1];
        for(Map.Entry<Integer, ArrayList<Integer>> keyVal : hashMap.entrySet()) {
            if(keyVal.getValue().size() == 1) {
                rst[0] = keyVal.getKey();
                break;
            }
        }
        rst[1] = hashMap.get(rst[0]).get(0);
        for(int i = 2;i<rst.length;i++){
            ArrayList<Integer> arrayList = hashMap.get(rst[i-1]);
            for(int j = 0;j<arrayList.size();j++){
                if(arrayList.get(j) != rst[i-2]) {
                    rst[i] = arrayList.get(j);
                }
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        hash1743 obj = new hash1743();
        int[][] arr = {
                {4,-2},
                {1,4},
                {-3,1}
        };
        int[] ints = obj.restoreArray(arr);
        System.out.println(Arrays.toString(ints));
    }
}
