import java.util.*;

public class permutation1850 {

/*
例如，num = "5489355142" ：
第 1 个最小妙数是 "5489355214"
第 2 个最小妙数是 "5489355241"
第 3 个最小妙数是 "5489355412"
第 4 个最小妙数是 "5489355421"
 */
    public int getMinSwaps(String num, int k) {
        int[] nums = new int[num.length()];
        for(int j = 0;j<num.length();j++){
            nums[j] = num.charAt(j) - '0';
        }
        for(int i = 0;i<k;i++){
            nums = getNextNumber(nums);
        }
        //test
//        System.out.println(Arrays.toString(nums));
        //计算逆序对 o(n^2)
        HashMap<Integer, Queue<Integer>> hashMap = new HashMap<>();
        for(int i = 0 ;i<num.length();i++){
            int val = num.charAt(i) - '0';
            if(hashMap.containsKey(val)) {
                Queue<Integer> queue = hashMap.get(val);
                queue.offer(i);
                hashMap.put(val,queue);
            }else{
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                hashMap.put(val,queue);
            }
        }
        //test
        System.out.println(hashMap.toString());
        int[] nixuArray = new int[num.length()];
        for(int i = 0;i<nixuArray.length;i++){
            Queue<Integer> queue = hashMap.get(nums[i]);
            nixuArray[i] = queue.poll();
        }
        //bubble sort
        int cnts = 0;
        for(int i = 0;i<nixuArray.length;i++){
            for(int j = i+1;j<nixuArray.length;j++){
                if(nixuArray[i] > nixuArray[j]) cnts++;
            }
        }

        return cnts;
    }

    public int[] getNextNumber(int[] nums) {
        int x = 0;
        for(int i = nums.length-1;i>0;i--){
            if(nums[i] > nums[i-1]) {
                x = i - 1;
                break;
            }
        }
        int y = 0;
        for(int i = nums.length-1;i>=0;i--){
            if(nums[i] > nums[x]) {
                y = i;
                break;
            }
        }

        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
        //reverse x-> nums.length
        int left = x+1;
        int right = nums.length-1;
        while (left < right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

        return nums;
    }

    public static void main(String[] args) {
        String num = "00123";
        permutation1850 obj = new permutation1850();
        int minSwaps = obj.getMinSwaps(num, 1);
        System.out.println(minSwaps);
    }

}
