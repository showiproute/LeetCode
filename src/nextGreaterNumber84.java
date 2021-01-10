public class nextGreaterNumber84 {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length ==0 )return 0;
        int maxValue = 0;
        for(int i = 0;i<heights.length;i++){
            int weight = findMaxWeight(heights, i);
            maxValue = Math.max(maxValue,weight*heights[i]);
        }

        return maxValue;
    }

    public int findMaxWeight(int[] heights,int index) {
        int left = index;
        int right = index;

        while(left >0 && heights[left-1] >= heights[index]){
            left--;
        }

        while(right<heights.length-1 && heights[right+1] >= heights[index]){
            right++;
        }

        return right-left+1;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        int[] rst = {5,5,6,-1,3,-1};
        nextGreaterNumber84 obj = new nextGreaterNumber84();
        int i = obj.largestRectangleArea(arr);
        System.out.println(i);
    }
}
