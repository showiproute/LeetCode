public class digit1486 {

    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        for(int i = 0;i<nums.length;i++){
            nums[i] = start+i*2;
        }
        int rst = 0;
        for(int i = 0;i<nums.length;i++){
            rst^=nums[i];
        }

        return rst;
    }


}
