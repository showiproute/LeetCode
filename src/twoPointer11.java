public class twoPointer11 {

    //暴力解法 O(n^2)
    //用双指针做
    public int maxArea(int[] height) {
        if(height == null || height.length ==0 ) return 0;
        int maxArea = 0;
        int i = 0;
        int j = height.length-1;
        while(i < j){
            int h = Math.min(height[i],height[j]);
            maxArea =Math.max(h*(j-i),maxArea);
            if(height[i] <= height[j]) {
                i++;
            }else{
                j--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,2,3,4};
        twoPointer11 obj = new twoPointer11();
        int i = obj.maxArea(arr);
        System.out.println(i);
    }


}
