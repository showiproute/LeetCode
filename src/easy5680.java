public class easy5680 {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int index = Integer.MAX_VALUE;

        for(int i = 0;i<points.length;i++){
            int val = Math.abs(points[i][0]-x)+Math.abs(points[i][1]-y);
            if(min >= val) {
                index = Math.min(index,points[i][0]);
                min = val;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2},
                {3,1},
                {2,4},
                {2,3},
                {4,4}
        };
        easy5680 obj = new easy5680();
        int i = obj.nearestValidPoint(3, 4, arr);
        System.out.println(i);
    }
}
