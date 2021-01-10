import java.util.ArrayList;
import java.util.Comparator;

public class backTracking473 {

    public int slide;
    public boolean[] visit;
    public int[] nums;
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        int sums = 0;
        for (int i = 0; i < nums.length; i++) {
            sums += nums[i];
        }
        if (sums % 4 != 0) return false;
        this.slide = sums / 4;
        this.visit = new boolean[nums.length];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] newNums = new int[nums.length];
        for (int i = 0; i < newNums.length; i++) {
            newNums[i] = list.get(i);
        }
        this.nums = newNums;
        for(int i =0 ;i<4;i++){
            if(!dfs(0,0)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int index,int sum) {
        if(sum == slide) return true;
        for(int i = index;i<nums.length;i++){
            if(visit[i]) continue;
            if(nums[i]+sum <= slide) {
                visit[i] = true;
                if(dfs(i+1,nums[i]+sum)){
                    return true;
                }
                visit[i] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,3,4,4,4,4,5,5,5,5};
        backTracking473 obj = new backTracking473();
        boolean makesquare = obj.makesquare(nums);
        System.out.println(makesquare);
    }



}
