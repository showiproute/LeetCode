
public class binarySearch1011 {

    public int shipWithinDays(int[] weights, int D) {
        int left = 0;
        int right = 0;
        for(int i = 0 ;i<weights.length;i++){
            right +=weights[i];
        }
        while (left <= right) {
            int mid = left+(right-left) / 2;
//            System.out.println("mid"+mid);
            if(helper(weights,D,mid)) {
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean helper(int[] weights,int D,int dis) {
        int cnts = 0;
        int temp = 0;
        for(int i = 0;i<weights.length;i++){
            if(weights[i] > dis) return false;
            temp+=weights[i];
            if(temp > dis) {
                cnts++;
                temp = weights[i];
            }else if(temp == dis) {
                cnts++;
                temp = 0;
            }
        }
        if(temp < dis && temp != 0) {
            cnts++;
        }
//        System.out.println(cnts);
        return cnts<=D;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 1;
        binarySearch1011 obj = new binarySearch1011();
        System.out.println(obj.shipWithinDays(weights,D));
//        boolean helper = obj.helper(weights, D, 2);
//        System.out.println(helper);
    }
}
