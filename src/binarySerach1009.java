public class binarySerach1009 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        for(int i = 0;i<matrix.length;i++){
            boolean find = binarySearch(matrix[i], target);
            if(find) {
                return true;
            }
        }

        return false;
    }

    public boolean binarySearch(int[] martix,int target){
        int left = 0;
        int right = martix.length-1;
        while(left <= right) {
            int mid = left+(right-left)/2;
            if(martix[mid] < target) {
                left = mid+1;
            }else if(martix[mid] > target) {
                right = mid-1;
            }else if(martix[mid] == target) {
                return true;
            }
        }

        return false;
    }


}
