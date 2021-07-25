import java.util.*;

public class dfs1743 {

    //输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
    //输出：[-2,4,1,-3]
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer,ArrayList<Integer>> hashMap = new HashMap<>();
        for(int i =0 ;i<adjacentPairs.length;i++){
            hashMap.putIfAbsent(adjacentPairs[i][0],new ArrayList<Integer>());
            hashMap.putIfAbsent(adjacentPairs[i][1],new ArrayList<Integer>());
            hashMap.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
            hashMap.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);
        }
        int first = -1;
        for(Map.Entry<Integer,ArrayList<Integer>> keyVal : hashMap.entrySet()) {
            if(keyVal.getValue().size() == 1) {
                first = keyVal.getKey();
                break;
            }
        }

        int[] rst = new int[adjacentPairs.length+1];
        rst[0] = first;
        rst[1] = hashMap.get(first).get(0);
        for(int i = 2;i<rst.length;i++){
            int key = rst[i - 1];
            ArrayList<Integer> list = hashMap.get(key);
            for(int j = 0;j<list.size();j++){
                if(list.get(j) != rst[i-2]) {
                    rst[i] = list.get(j);
                    break;
                }
            }
        }

       return rst;
    }

//    public void dfs(HashMap<Integer,ArrayList<Integer>> hashMap,ArrayList<Integer> temp,int first) {
//        /*
//            4  | -2 , 1
//    -2 | 4
//    1  | 4 , -3
//    -3 | 1
//         */
//        if(temp.contains(first)) return;
//        temp.add(first);
//        ArrayList<Integer> arrayList = hashMap.get(first);
//        for (Integer integer : arrayList) {
//            if (temp.contains(integer)) continue;
//            dfs(hashMap, temp, integer);
//        }
//
//    }

    public static void main(String[] args) {
        int[][] adj = {
                {4,-2},
                {1,4},
                {-3,1}
        };
        dfs1743 obj = new dfs1743();
        int[] ints = obj.restoreArray(adj);
        System.out.println(Arrays.toString(ints));
    }
}
