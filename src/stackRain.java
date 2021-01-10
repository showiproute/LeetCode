import java.util.Scanner;
import java.util.Stack;

public class stackRain {

    public long getRainSum(int N,int[] nums) {
        if(N<=0 || nums == null || nums.length ==0 ) return 0;

        int i = 0;
        int j = N-1;
        int left=nums[i];
        int right = nums[j];
        long sum  =0;
        while(i<j) {
            if(left < right) {
                i++;
                if(nums[i] >= left) {
                    left = nums[i];
                }else{
                    sum += left-nums[i];
                }
            }else {
                j--;
                if(nums[j] > right) {
                    right = nums[j];
                }else{
                    sum+=right-nums[j];
                }
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stackRain obj = new stackRain();
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            long rainSum = obj.getRainSum(n, arr);
            System.out.println(rainSum);
        }
    }
}
