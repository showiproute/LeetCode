import java.util.HashSet;

public class moni457 {

    public boolean circularArrayLoop(int[] nums) {
        if(nums == null || nums.length < 2) return false;
        //输入：nums = [2,-1,1,2,2]
        //输出：true
        //解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
        int dis = 0;
        for(int i = 0;i<nums.length;i++){
            int newDis = Math.abs((nums[i] + i + nums.length)%nums.length);
            if(newDis == i) continue;
            else dis = newDis;
            HashSet<Integer> visited = new HashSet<>();
            visited.add(i);
            System.out.println("step"+i);
            //-2,-17,-1,-2,-2
            while (true) {
                System.out.println("dis"+dis);
                if(visited.contains(dis)) {
                    if(visited.size() > 1 && nums[dis] * nums[i] >0 ) return true;
                    else break;
                }
                if(nums[dis] * nums[i] < 0) break;
                visited.add(dis);
                if((dis+nums[dis] + nums.length) % nums.length < 0) {
                    newDis = ((dis+nums[dis] + nums.length) % nums.length + dis + nums.length) % nums.length;
                }else{
                    newDis =(dis+nums[dis] + nums.length) % nums.length;
                }
                if(newDis == dis) {
                    break;
                }
                else dis = newDis;
            }
        }

        return false;
    }



    public static void main(String[] args) {
        int[] nums = {-2,1,-1,-2,-2};
        moni457 obj = new moni457();
        boolean b = obj.circularArrayLoop(nums);
        System.out.println(b);
//        System.out.println((1-17)%5);
    }
}
