import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class greedy1046 {

    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<stones.length;i++){
            list.add(stones[i]);
        }
        while (list.size() > 1) {
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            int a = list.get(0);
            int b = list.get(1);
            if(a == b) {
                list.remove(1);
                list.remove(0);
            }else{
                list.remove(1);
                list.set(0,a-b);
            }
        }

        return list.size() == 0 ? 0 : list.get(0);
    }

    public static void main(String[] args) {
        int[] nums = {2,7,4,1,8,1};
        greedy1046 obj = new greedy1046();
        int i = obj.lastStoneWeight(nums);
        System.out.println(i);
    }


}
